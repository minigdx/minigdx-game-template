package your.game

import com.github.dwursteisen.minigdx.GameApplicationBuilder
import com.github.dwursteisen.minigdx.GameConfiguration
import com.github.dwursteisen.minigdx.GameScreenConfiguration
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.get
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    // Look for the first canvas in current page.
    val canvas = document.getElementsByTagName("canvas")[0] ?: throw IllegalArgumentException(
        "No <canvas> has been found in the current page. Check that the page including your javascript game" +
            "has a <canvas> tag to render the game in."
    )

    // Get the actual root path and compute the root path to let the game load the resources from
    // the correct URL.
    // This portion may need to be customized regarding the service where the game is deployed (itch.io, ...)
    var rootPath = window.location.protocol + "//" + window.location.host + window.location.pathname
    rootPath = rootPath.replace("index.html", "")


    GameApplicationBuilder(
        gameConfigurationFactory = {
            GameConfiguration(
                // Configure how the game will be rendered in the canvas
                gameScreenConfiguration = GameScreenConfiguration.WithRatio(16f / 9f),
                // What canvas to use to render the game
                canvas = canvas as HTMLCanvasElement,
                // What root path to use. It's use so minigdx can access to resources with the correct URL.
                rootPath = rootPath,
                // Is debug information should be displayed? (hitbox, ...)
                debug = false,
                // The name of your game
                gameName = "My Game - running in a browser"
            )
        },
        // Creation of your game
        gameFactory = { MyGame(it) }
    ).start() // ! Don't forget to call this method to start your game!
}
