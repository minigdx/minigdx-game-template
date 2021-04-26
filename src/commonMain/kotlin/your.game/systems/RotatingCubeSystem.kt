package your.game.systems

import com.github.dwursteisen.minigdx.Seconds
import com.github.dwursteisen.minigdx.ecs.entities.Entity
import com.github.dwursteisen.minigdx.ecs.entities.position
import com.github.dwursteisen.minigdx.ecs.systems.EntityQuery
import com.github.dwursteisen.minigdx.ecs.systems.System
import your.game.components.Cube

/**
 * Rotate entities with [Cube] component by 90 degres per second.
 */
class RotatingCubeSystem : System(EntityQuery.of(Cube::class)) {

    override fun update(delta: Seconds, entity: Entity) {
        entity.position.addLocalRotation(y = 90f, delta = delta)
    }
}
