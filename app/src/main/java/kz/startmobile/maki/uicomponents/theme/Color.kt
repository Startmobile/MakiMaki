package kz.startmobile.maki.uicomponents.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


sealed class ThemeColors {

    abstract val primary: Color
    abstract val primaryVariant: Color
    abstract val secondary: Color

    abstract fun values(): Colors

    object Light : ThemeColors() {
        override val primary = Color(0xFFBB86FC)
        override val primaryVariant = Color(0xFF3700B3)
        override val secondary = Color(0xFF03DAC5)

        override fun values() = lightColors(primary, primaryVariant, secondary)
    }

    object Dark : ThemeColors() {
        override val primary = Color(0xFF6200EE)
        override val primaryVariant = Color(0xFF3700B3)
        override val secondary = Color(0xFF03DAC5)

        override fun values(): Colors = darkColors(primary, primaryVariant, secondary)
    }
}