package hotlite.ext

import com.example.InteractionApi.InventoryInteraction
import net.runelite.api.widgets.Widget

object WidgetExt {
    fun Widget.useItem(vararg actions: String) {
        InventoryInteraction.useItem(this, *actions)
    }
}