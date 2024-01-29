package ext.runelite

import com.example.InteractionApi.TileObjectInteraction
import ext.java.Graphics2DExt.drawColor
import ext.java.Graphics2DExt.fillColor
import ext.kotlin.KClassExt.getInstance
import ext.runelite.SceneExt.getObjects
import hotlite.Colors
import net.runelite.api.Client
import net.runelite.api.TileObject
import java.awt.Color
import java.awt.Graphics2D

object TileObjectExt {
    val client = Client::class.getInstance()
    fun TileObject.interact(vararg actions: String) {
        TileObjectInteraction.interact(this, *actions)
    }

    fun TileObject.renderTile(graphics: Graphics2D,
                         drawBounds: Boolean = true,
                         boundsColor: Color = Colors.DEFAULT_BOUNDS_COLOR,
                         drawFill: Boolean = true,
                         fillColor: Color = Colors.DEFAULT_FILL_COLOR
    ) {
        canvasTilePoly?.let {
            if (drawFill) {
                graphics.fillColor(fillColor, it)
            }
            if (drawBounds) {
                graphics.drawColor(boundsColor, it)
            }
        }
    }

    fun TileObject.isOf(vararg ids: Int) : Boolean {
        return ids.contains(id)
    }

    fun TileObject.isOf(vararg names: String) : Boolean {
        return names.contains(client.getObjectDefinition(id).name) || names.contains(
            client.getObjectDefinition(id).impostor.name)
    }

    fun<T: TileObject> Iterable<T>.filterIDs(vararg ids: Int) : List<T> {
        return filter { ids.contains(it.id) }
    }

    fun<T: TileObject> Iterable<T>.filterNames(vararg names: String) : List<T> {
        return filter { it.isOf(*names) }
    }

    @JvmStatic
    fun TileObject.Companion.withIDs(vararg ids: Int) : List<TileObject> {
        return client.scene.getObjects().filter { it.isOf(*ids)}
    }

    @JvmStatic
    fun TileObject.Companion.withNames(vararg names: String) : List<TileObject> {
        return client.scene.getObjects().filter { it.isOf(*names)}
    }
}