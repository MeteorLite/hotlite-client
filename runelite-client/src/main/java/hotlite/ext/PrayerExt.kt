package hotlite.ext

import com.example.InteractionApi.PrayerInteraction
import net.runelite.api.Prayer

object PrayerExt {
    fun Prayer.toggle() {
        PrayerInteraction.togglePrayer(this)
    }

    fun Prayer.setEnabled(enabled: Boolean) {
        PrayerInteraction.setPrayerState(this, enabled)
    }
}