package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.DecorativeObject

object DecorativeObjectExt {

    val client = Client::class.getInstance()

    fun DecorativeObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
}