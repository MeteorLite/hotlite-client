package hotlite.plugins.example

import hotlite.ext.ActorExt.renderTile
import net.runelite.client.ui.overlay.Overlay
import java.awt.Dimension
import java.awt.Graphics2D

class ExampleOverlay(val plugin: ExamplePlugin) : Overlay() {
    override fun render(graphics: Graphics2D): Dimension? {
        for (player in plugin.players) {
            player.renderTile(graphics)
        }
        return null
    }
}