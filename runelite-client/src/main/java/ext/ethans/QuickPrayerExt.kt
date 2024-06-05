package ext.ethans

import com.example.EthanApiPlugin.Collections.query.QuickPrayer
import com.example.EthanApiPlugin.EthanApiPlugin

object QuickPrayerExt {
    /**
     * Checks whether an individual quick prayer is active
     */
    fun QuickPrayer.isActive() : Boolean {
        return EthanApiPlugin.isQuickPrayerActive(this)
    }
}