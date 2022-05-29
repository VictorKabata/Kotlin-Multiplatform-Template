import androidx.compose.ui.window.application
import ui.screens.MainScreen

fun main() {
    // ToDo: Init koin

    return application {
        MainScreen(applicationScope = this)
    }
}
