package ext.runelite

import ext.ExtUtil.getInstance
import ext.java.Graphics2DExt.drawColor
import ext.java.Graphics2DExt.fillColor
import hotlite.Colors
import net.runelite.api.Actor
import net.runelite.api.NPC
import net.runelite.api.Player
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer
import java.awt.Color
import java.awt.Graphics2D

object ActorExt {

    val modelOutlineRenderer = ModelOutlineRenderer::class.getInstance()

    fun Actor.renderTile(graphics: Graphics2D,
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

    fun Actor.renderOutline(borderWidth: Int = 4,
                            outlineFeather: Int = 4,
                            boundsColor: Color = Colors.DEFAULT_BOUNDS_COLOR) {
        if (this is NPC) {
            modelOutlineRenderer.drawOutline(this, borderWidth, boundsColor, outlineFeather)
        }
        else if (this is Player)
            modelOutlineRenderer.drawOutline(this, borderWidth, boundsColor, outlineFeather)
    }

    fun<T: Actor> Iterable<T>.withName(vararg names: String) : List<T> {
        return filter { names.contains(it.name) }
    }
}