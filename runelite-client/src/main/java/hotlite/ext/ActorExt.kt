package hotlite.ext

import hotlite.Colors
import net.runelite.api.Actor
import java.awt.Color
import java.awt.Graphics2D

object ActorExt {
    fun Actor.renderTile(graphics: Graphics2D,
                         drawBounds: Boolean = true,
                         boundsColor: Color = Colors.DEFAULT_BOUNDS_COLOR,
                         drawFill: Boolean = true,
                         fillColor: Color = Colors.DEFAULT_FILL_COLOR
    ) {
        canvasTilePoly?.let {
            if (drawFill) {
                graphics.color = fillColor
                graphics.fill(it)
            }
            if (drawBounds) {
                graphics.color = boundsColor
                graphics.draw(it)
            }
        }
    }
}