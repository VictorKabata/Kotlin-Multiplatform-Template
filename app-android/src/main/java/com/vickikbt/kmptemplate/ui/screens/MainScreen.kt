package com.vickikbt.kmptemplate.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vickikbt.kmptemplate.presentation.viewmodels.MainViewModel
import org.koin.androidx.compose.get

@Composable
fun MainScreen(viewModel: MainViewModel = get()) {
    val greeting = viewModel.greeting.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        greeting?.let {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = it,
                color = Color.Black
            )
        }
    }
}
