package your.game.systems

import com.github.dwursteisen.minigdx.Seconds
import com.github.dwursteisen.minigdx.ecs.entities.Entity
import com.github.dwursteisen.minigdx.ecs.entities.position
import com.github.dwursteisen.minigdx.ecs.systems.EntityQuery
import com.github.dwursteisen.minigdx.ecs.systems.System
import com.github.dwursteisen.minigdx.input.Key
import your.game.components.Cube
import kotlin.math.abs
import kotlin.math.cos

/**
 * Rotate entities with [Cube] component by 90 degrees per second.
 */
class RotatingCubeSystem : System(EntityQuery.of(Cube::class)) {

    override fun update(delta: Seconds, entity: Entity) {
        val component = entity.get(Cube::class)
        // If the key SPACE is pressed one time,
        // then set the duration of the component to 2 seconds.
        if(input.isKeyJustPressed(Key.SPACE)) {
            component.duration = 2f
        }

        // If there is a duration, the cube can be scaled
        if(component.duration > 0f) {
            component.duration -= delta
            // Compute the scale regarding the remaining duration using a cosine function
            // and keep the absolute value so the scale is always positive.
            val scale = abs(cos(component.duration))

            // Set the scale of the cube.
            entity.position.setLocalScale(
                x = scale,
                y = scale,
                z = scale
            )
        }

        // Rotate the cube of 90 degrees per second.
        entity.position.addLocalRotation(y = 90f, delta = delta)
    }
}
