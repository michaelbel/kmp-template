@file:OptIn(ExperimentalComposeUiApi::class)

package org.michaelbel.template

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        CanvasBasedWindow(
            title = "Main",
            canvasElementId = "ComposeTarget"
        ) {
            App()
        }
    }
}