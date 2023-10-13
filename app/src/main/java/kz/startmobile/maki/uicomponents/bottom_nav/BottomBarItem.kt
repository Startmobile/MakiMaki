package kz.startmobile.maki.uicomponents.bottom_nav

import kz.startmobile.maki.R

sealed class BottomBarItem(
    val titleResId: Int, val icon: Int, val iconFocused: Int
) {
    object Home : BottomBarItem(
        titleResId = R.string.no_title,
        icon = R.drawable.ic_nav_home,
        iconFocused = R.drawable.ic_nav_home_active
    )

    object Search : BottomBarItem(
        titleResId = R.string.no_title,
        icon = R.drawable.ic_nav_search,
        iconFocused = R.drawable.ic_nav_search_active
    )

    object Orders : BottomBarItem(
        titleResId = R.string.no_title,
        icon = R.drawable.ic_nav_orders,
        iconFocused = R.drawable.ic_nav_orders_active
    )

    object Profile : BottomBarItem(
        titleResId = R.string.no_title,
        icon = R.drawable.ic_nav_profile,
        iconFocused = R.drawable.ic_nav_profile_active
    )
}