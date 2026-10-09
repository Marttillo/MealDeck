package com.martillo.mealdeck.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.martillo.mealdeck.data.DataItem
import com.martillo.mealdeck.data.SearchRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(repository: SearchRepository) {
    var query by remember { mutableStateOf("") }
    val hits: List<DataItem> by repository.search(query)
        .collectAsStateWithLifecycle(emptyList())

    Column(Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Diary") }
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
             ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search") }
            )
            Button(
                onClick = {
                    /*scope.launch {
                        dao.insert(ContactsContract.CommonDataKinds.Note(text = text))
                        text = ""
                },*/

                }
            ) {
                Icon(Icons.Filled.Clear, contentDescription = "Clear")
            }
}
        LazyColumn {
            items(
                items = hits,
                key = {item ->"${item.source}-${item.id ?: item.code ?: item.name}"}
            ) { hit ->
                Row(
                    Modifier
                        .fillMaxWidth()

                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){


                    Text(hit.name, Modifier.weight(1f))
                    Text(hit.kcal?.toString() ?: "-")
                }
            }

        }
    }
}

