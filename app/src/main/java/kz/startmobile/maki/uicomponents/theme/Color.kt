package kz.startmobile.maki.uicomponents.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


sealed class ThemeColors {

    abstract val primary: Color
    abstract val primaryVariant: Color
    abstract val secondary: Color
    abstract val searchBarColor: Color
    abstract val activeBottomNavColor: Color

    abstract fun values(): Colors

    object Light : ThemeColors() {
        override val primary = Color(0xFFBB86FC)
        override val primaryVariant = Color(0xFF3700B3)
        override val secondary = Color(0xFF03DAC5)
        override val searchBarColor = Color(0xFFF2F3F5)
        override val activeBottomNavColor = Color(0xFFFFCC66)

        override fun values() = lightColors(primary, primaryVariant,
            secondary, searchBarColor,
            activeBottomNavColor)
    }

    object Dark : ThemeColors() {
        override val primary = Color(0xFF6200EE)
        override val primaryVariant = Color(0xFF3700B3)
        override val secondary = Color(0xFF03DAC5)
        override val searchBarColor = Color(0xFFF2F3F5)
        override val activeBottomNavColor = Color(0xFFFFCC66)

        override fun values(): Colors = darkColors(
            primary, primaryVariant,
            secondary, searchBarColor,
            activeBottomNavColor)
    }
}