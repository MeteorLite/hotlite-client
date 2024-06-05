package hotlite.plugins.tutorial

import net.runelite.api.widgets.Widget
import net.runelite.client.ui.overlay.Overlay
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class TutorialOverlay() : Overlay() {
    val widgets = ArrayList<Widget>()
    override fun render(graphics: Graphics2D): Dimension? {
        graphics.color = Color.CYAN
        for (widget in widgets) {
            graphics.draw(widget.bounds)
        }
        return null
    }
}