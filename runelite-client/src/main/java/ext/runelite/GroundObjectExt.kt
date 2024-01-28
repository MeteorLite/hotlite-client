package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.GroundObject

object GroundObjectExt {

    val client = Client::class.getInstance()

    fun GroundObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
}