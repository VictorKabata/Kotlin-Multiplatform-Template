import androidx.compose.ui.window.application
import screens.MainWindow

fun main() {
    return application {
        MainWindow(applicationScope = this)
    }
}
