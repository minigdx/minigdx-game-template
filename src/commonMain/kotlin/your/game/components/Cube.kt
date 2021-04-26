package your.game.components

import com.github.dwursteisen.minigdx.Seconds
import com.github.dwursteisen.minigdx.ecs.components.Component

/**
 * Cube component: tag to mark entities that are cube.
 */
class Cube(
    // Remaining time of the cube movement
    var duration: Seconds = 0f
) : Component
