package kz.startmobile.maki.uicomponents.search_bar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.startmobile.maki.uicomponents.GraySearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MaterialSearchBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Search",
    shape: Shape = RoundedCornerShape(
        topEnd = 14.dp,
        topStart = 14.dp,
        bottomEnd = 14.dp,
        bottomStart = 14.dp
    ),
    items: MutableList<String> = remember {
        mutableListOf(
            "Hot dog",
            "Chicken",
            "Pizza"
        )
    },
    searchText: MutableState<String> = remember {
        mutableStateOf("")
    },
    colorOfBackground: SearchBarColors = SearchBarDefaults.colors(GraySearchBar),
    colorOfLeadingIcon: Color = GraySearchBar
) {
    //var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    DockedSearchBar(
        query = searchText.value,
        onQueryChange = {searchText.value = it},
        onSearch =  {
            items.add(searchText.value)
            active = false
            searchText.value = ""
            Log.e("click", "onSearch()")
        },
        active = active,
        onActiveChange = {
            active = it
            Log.e("click", "onActiveChange()")
                         },
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .then(modifier),
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",

            )
        },
        trailingIcon = {
            if(active) {
                Icon(
                    modifier = Modifier.clickable {
                        if(searchText.value.isNotEmpty()) {
                            searchText.value = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon"
                )
            }
        },
        colors = colorOfBackground,

    ) {(Modifier
        .padding(horizontal = 0.dp)
        .background(Color.Green))

        items.forEach{
            ListItemsInLoop(it)
        }
    }
}

@Composable
private fun ListItemsInLoop(
    item: String
) {
    Row(modifier = Modifier.padding(14.dp)){
        Icon(
            modifier = Modifier.padding(end = 10.dp),
            imageVector = Icons.Default.History,
            contentDescription = "History Icon"
        )
        Text(text = item)
    }
}