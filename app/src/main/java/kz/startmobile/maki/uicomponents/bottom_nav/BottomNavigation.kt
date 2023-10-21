package kz.startmobile.maki.uicomponents.bottom_nav

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.startmobile.maki.uicomponents.MakiMakiTheme
import kz.startmobile.maki.uicomponents.OrangeBottomNav

@Preview
@Composable
fun CustomBottomNavigation() {
            BottomNavigation(
                backgroundColor = Color.White
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
                    BottomNavigationItem(
                        selected = selectedItemPosition.value == index,
                        onClick = {
                            selectedItemPosition.value = index
                        },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    id = if (selectedItemPosition.value == index) {
                                        item.iconFocused
                                    } else {
                                        item.icon
                                    }
                                ),
                                contentDescription = null,
                                tint = if (selectedItemPosition.value == index) {
                                    OrangeBottomNav
                                } else {
                                    Color.Gray
                                }
                            )
                        },
                        selectedContentColor = Color.Yellow,
                        unselectedContentColor = Color.Gray,
                        //                        androidx.compose.material3.NavigationBarItemDefaults
//                            .colors(
//                                selectedIconColor = MaterialTheme.colors.surface,
//
//                                indicatorColor = Color.White
//                            )
                    )
                }
            }
        }
