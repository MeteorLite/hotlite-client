package ext.runelite

import com.example.InteractionApi.TileObjectInteraction
import ext.java.Graphics2DExt.drawColor
import ext.java.Graphics2DExt.fillColor
import hotlite.Colors
import net.runelite.api.TileObject
import java.awt.Color
import java.awt.Graphics2D

object TileObjectExt {
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
}