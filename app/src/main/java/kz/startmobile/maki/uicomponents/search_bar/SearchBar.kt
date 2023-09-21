package kz.startmobile.maki.uicomponents.search_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MaterialSearchBar(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 10.dp),
    placeholder: String = "Search" ,
    shape: RoundedCornerShape = RoundedCornerShape(
        topEnd = 14.dp,
        topStart = 14.dp,
        bottomEnd = 14.dp,
        bottomStart = 14.dp
    )
) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableListOf(
            "Hot dog",
            "Chicken",
            "Pizza"
        )
    }
    SearchBar(
        query = text,
        onQueryChange = {text = it},
        onSearch =  {
            items.add(text)
            active = false
            text = ""
        },
        active = active,
        onActiveChange = { active = it},
        shape = shape,
        modifier = modifier,
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon")
        },
        trailingIcon = {
            if(active) {
                Icon(
                    modifier = Modifier.clickable {
                        if(text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon"
                )
            }
        }
    ) {
        items.forEach{
            Row(modifier = Modifier.padding(14.dp)){
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.History,
                    contentDescription = "History Icon"
                )
                Text(text = it)
            }
        }
    }
}