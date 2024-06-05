package ext.runelite

import com.example.Packets.WidgetPackets
import net.runelite.api.widgets.Widget

object WidgetExt {
    fun Widget.doAction(action: String) {
        WidgetPackets.queueWidgetAction(this, action)
    }
}