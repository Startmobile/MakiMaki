package kz.startmobile.maki.uicomponents.search_bar

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    ),
    items: MutableList<String> = remember {
        mutableListOf(
            "Hot dog",
            "Chicken",
            "Pizza"
        )
    }
) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val paddingValues = if (active) {
        PaddingValues(16.dp)
    } else {
        PaddingValues(0.dp)
    }

    SearchBar(
        query = text,
        onQueryChange = {text = it},
        onSearch =  {
            items.add(text)
            active = false
            text = ""
            Log.e("click", "onSearch()")
        },
        active = active,
        onActiveChange = {
            active = it
            Log.e("click", "onActiveChange()")
                         },
        shape = shape,
        modifier = if (active) {
            Log.e("event", "padding yes - $active")
            Modifier.padding(horizontal = 0.dp, vertical = 0.dp)
                .animateContentSize ()
        } else {
            Log.e("event", "padding no $active")
            modifier.animateContentSize()

        },
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
        },

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