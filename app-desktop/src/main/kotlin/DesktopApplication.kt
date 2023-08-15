import androidx.compose.ui.window.application
import ui.screens.MainWindow

fun main() {
    return application {
        MainWindow(applicationScope = this)
    }
}
