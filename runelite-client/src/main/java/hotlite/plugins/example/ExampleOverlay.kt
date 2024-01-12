package hotlite.plugins.example

import ext.runelite.ActorExt.renderTile
import net.runelite.client.ui.overlay.Overlay
import net.runelite.client.ui.overlay.OverlayLayer
import net.runelite.client.ui.overlay.OverlayPosition
import java.awt.Dimension
import java.awt.Graphics2D

class ExampleOverlay(val plugin: ExamplePlugin) : Overlay() {

    init {
        setPosition(OverlayPosition.DYNAMIC)
        super.setLayer(OverlayLayer.ABOVE_SCENE)
    }

    override fun render(graphics: Graphics2D): Dimension? {
        for (player in plugin.players.toList()) {
            player.renderTile(graphics)
        }
        return null
    }
}