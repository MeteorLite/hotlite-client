package ext.runelite

import ext.kotlin.KClassExt.getInstance
import ext.runelite.ProjectileExt.isOf
import net.runelite.api.Client
import net.runelite.api.Deque
import net.runelite.api.Projectile

object DequeExt {

    val client = Client::class.getInstance()

    fun Deque<Projectile>.withID(vararg ids: Int) : List<Projectile> {
        return client.projectiles.filter { it.isOf(*ids) }
    }
}