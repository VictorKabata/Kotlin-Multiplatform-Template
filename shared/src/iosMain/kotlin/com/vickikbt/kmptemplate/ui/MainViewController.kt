package com.vickikbt.kmptemplate.ui

import androidx.compose.ui.window.ComposeUIViewController
import com.vickikbt.kmptemplate.ui.screens.MainScreen
import kotlin.experimental.ExperimentalObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("MainScreen")
fun MainViewController() = ComposeUIViewController { MainScreen() }