package screens

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
        title = "KMP Template Desktop",
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 800.dp, // or Dp.Unspecified,
            height = 640.dp, // or Dp.Unspecified,
        )
    ) {
        MainScreen()
    }
}
