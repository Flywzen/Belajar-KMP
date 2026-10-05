package com.mynim_123140148.statemanagementmvvm.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF3F51B5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDDE1FF),
    onPrimaryContainer = Color(0xFF00105C),
    background = Color(0xFFFBFBFF),
    onBackground = Color(0xFF1B1B1F),
    surface = Color(0xFFFBFBFF),
    onSurface = Color(0xFF1B1B1F),
    surfaceVariant = Color(0xFFE3E1EC),
    onSurfaceVariant = Color(0xFF46464F)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFB9C3FF),
    onPrimary = Color(0xFF00218D),
    primaryContainer = Color(0xFF2E3A8C),
    onPrimaryContainer = Color(0xFFDDE1FF),
    background = Color(0xFF121316),
    onBackground = Color(0xFFE4E1E6),
    surface = Color(0xFF121316),
    onSurface = Color(0xFFE4E1E6),
    surfaceVariant = Color(0xFF46464F),
    onSurfaceVariant = Color(0xFFC7C5D0)
)

@Composable
private fun animated(target: Color): Color =
    animateColorAsState(target, tween(400), label = "themeColor").value

/** Transisi warna halus saat dark mode di-toggle. */
@Composable
fun AppTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    val t: ColorScheme = if (darkTheme) DarkColors else LightColors
    val colors = t.copy(
        primary = animated(t.primary),
        onPrimary = animated(t.onPrimary),
        primaryContainer = animated(t.primaryContainer),
        onPrimaryContainer = animated(t.onPrimaryContainer),
        background = animated(t.background),
        onBackground = animated(t.onBackground),
        surface = animated(t.surface),
        onSurface = animated(t.onSurface),
        surfaceVariant = animated(t.surfaceVariant),
        onSurfaceVariant = animated(t.onSurfaceVariant)
    )
    MaterialTheme(colorScheme = colors, content = content)
}
