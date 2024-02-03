package hotlite.plugins.example

import com.google.inject.Inject
import ext.runelite.ActorExt.renderTile
import ext.runelite.GameObjectExt.withID
import ext.runelite.NPCExt.forEach
import ext.runelite.NPCExt.withName
import ext.runelite.PlayerExt.forEach
import net.runelite.api.GameObject
import net.runelite.api.NPC
import net.runelite.api.ObjectID
import net.runelite.api.Player
import net.runelite.client.ui.overlay.Overlay
import net.runelite.client.ui.overlay.OverlayLayer
import net.runelite.client.ui.overlay.OverlayPosition
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class ExampleOverlay : Overlay() {

    @Inject lateinit var plugin: ExamplePlugin

    init {
        setPosition(OverlayPosition.DYNAMIC)
        super.setLayer(OverlayLayer.ABOVE_SCENE)
    }

    override fun render(graphics: Graphics2D): Dimension? {
        Player.forEach { it.renderTile(graphics) }
        NPC.forEach { it.renderTile(graphics) }
        NPC.withName("Banker").forEach { it.renderTile(graphics, boundsColor = Color.YELLOW) }
        GameObject.withID(ObjectID.TREE).forEach {  }
        return null
    }
}