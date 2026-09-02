package com.mynim_123140148.praktikumpam01

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PraktikumPAM01",
    ) {
        App()
    }
}