package kz.startmobile.maki.uicomponents.bottom_nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.startmobile.maki.uicomponents.MakiMakiTheme

@Preview
@Composable
fun BottomNavigation() {
    Scaffold(bottomBar = {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)


        ) {
            val selectedItemPosition = remember {
                mutableStateOf(0)
            }
            val items = listOf(
                BottomBarItem.Home,
                BottomBarItem.Search,
                BottomBarItem.Orders,
                BottomBarItem.Profile,
            )
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemPosition.value == index,
                    onClick = { selectedItemPosition.value = index },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = if (selectedItemPosition.value == index) item.iconFocused else item.icon
                            ),
                            contentDescription = null
                        )
                    },
                    colors = androidx.compose.material3.NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = MaterialTheme.colors.surface,
                            indicatorColor = Color.White
                        )
                    )
            }
        }
    }) {

    }
}