package your.game

import com.github.dwursteisen.minigdx.GameApplicationBuilder
import com.github.dwursteisen.minigdx.GameConfiguration
import com.github.dwursteisen.minigdx.GameScreenConfiguration
import com.github.dwursteisen.minigdx.Window

object Main {

    @JvmStatic
    fun main(vararg args: String) {
        // This class can be run unsing the command `./gradlew runJvm`
        GameApplicationBuilder(
            gameConfigurationFactory = {
                GameConfiguration(
                    // Name of the game
                    gameName = "My Game",
                    // Screen configuration used for your game (ie: how should render your game)
                    gameScreenConfiguration = GameScreenConfiguration.WithRatio(16f / 9f),
                    // Is your game should use show debug information? (hitbox, ...)
                    debug = false,
                    // (JVM Specific configuration)
                    // Configuration of the window use to render your game
                    window = Window(
                        // Width of the window
                        1024,
                        // Height of the window
                        (1024 * 9f / 16f).toInt(),
                        // Name of the window
                        "My Game - running on the JVM"
                    )
                )
            },
            // Creation of your game
            gameFactory = { MyGame(it) }
        ).start() // Don't forget to call the start method to run your game!
    }
}
