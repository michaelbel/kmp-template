package org.michaelbel.template

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.michaelbel.kmptemplate.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kmp-template",
    ) {
        App()
    }
}