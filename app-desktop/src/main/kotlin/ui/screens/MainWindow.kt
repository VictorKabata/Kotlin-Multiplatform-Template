package ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import com.vickikbt.kmptemplate.ui.screens.MainScreen

@Composable
fun MainWindow(applicationScope: ApplicationScope) {
    Window(
        onCloseRequest = { applicationScope.exitApplication() },
        title = "KMP Template",
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 400.dp, // or Dp.Unspecified,
            height = 400.dp, // or Dp.Unspecified,
        )
    ) {
        MainScreen()
    }
}
