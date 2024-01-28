package ext.runelite

import ext.kotlin.KClassExt.getInstance
import net.runelite.api.Client
import net.runelite.api.WallObject

object WallObjectExt {

    val client = Client::class.getInstance()

    fun WallObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }
}