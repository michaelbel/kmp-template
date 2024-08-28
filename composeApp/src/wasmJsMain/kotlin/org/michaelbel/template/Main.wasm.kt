@file:OptIn(ExperimentalComposeUiApi::class)

package org.michaelbel.kmptemplate

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

fun main() {
    ComposeViewport(document.body!!) {
        App()
    }
}