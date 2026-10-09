package com.martillo.mealdeck.data

import com.martillo.mealdeck.data.local.Foods
import com.martillo.mealdeck.data.local.FoodsDao
import com.martillo.mealdeck.data.local.Ingredients
import com.martillo.mealdeck.data.local.IngredientsDao
import com.martillo.mealdeck.data.local.Recipe
import com.martillo.mealdeck.data.local.RecipeDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlin.collections.emptyList

/*sealed interface SearchHit {
    data class RecipeHit(val recipe: Recipe) : SearchHit
    data class FoodHit(val food: Foods) : SearchHit
    data class IngredientHit(val ingredient: Ingredients) : SearchHit
}
*/
class SearchRepository(
    private val IngredientDao: IngredientsDao,
    private val FoodsDao: FoodsDao,
    private val RecipeDao: RecipeDao,
    )
{
    @OptIn(ExperimentalCoroutinesApi::class)
    fun search(query: String): Flow<List<DataItem>> {
        val q = query.trim()
        return flowOf(q)
            .flatMapLatest(::searchAll)
            .distinctUntilChanged()
    }
    private fun searchAll(q: String): Flow<List<DataItem>> {
        // Minimum search string of 3 characters from Ingredients base
        val ingFlow :Flow<List<Ingredients>> =
            if (q.length>3) { IngredientDao.search(q)} else flowOf(emptyList())
        // Argument order is the screen order. combine calls mergeHits with the lists.
        return combine(
            RecipeDao.search(q),
            FoodsDao.search(q),
            ingFlow,
            ::mergeHits,
        )
    }

    private fun mergeHits(
        recipes: List<Recipe>,
        foods: List<Foods>,
        ingredients: List<Ingredients>,
    ): List<DataItem> {
        val foodItems: List<DataItem> = foods.map(Foods::toDataItem)
        val recipeItems: List<DataItem> = recipes.map(Recipe::toDataItem)
        val ingredientsItems: List<DataItem> = ingredients.map(Ingredients::toDataItem)

        return recipeItems + foodItems + ingredientsItems
    }

}