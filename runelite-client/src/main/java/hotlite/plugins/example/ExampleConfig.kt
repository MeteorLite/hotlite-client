/*
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package hotlite.plugins.example

import net.runelite.client.config.*
import java.awt.Color

@ConfigGroup("agility")
interface ExampleConfig : Config {
    @ConfigItem(
        keyName = "showClickboxes",
        name = "Show Clickboxes",
        description = "Show agility course and other obstacle clickboxes",
        position = 0
    )
    fun showClickboxes(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showLapCount",
        name = "Show Lap Count",
        description = "Enable/disable the lap counter",
        position = 1
    )
    fun showLapCount(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "lapTimeout",
        name = "Hide Lap Count",
        description = "Time until the lap counter hides/resets",
        position = 2
    )
    @Units(
        Units.MINUTES
    )
    fun lapTimeout(): Int {
        return 5
    }

    @ConfigItem(
        keyName = "lapsToLevel",
        name = "Show Laps Until Goal",
        description = "Show number of laps remaining until next goal is reached.",
        position = 3
    )
    fun lapsToLevel(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "lapsPerHour",
        name = "Show Laps Per Hour",
        description = "Shows how many laps you can expect to complete per hour.",
        position = 4
    )
    fun lapsPerHour(): Boolean {
        return true
    }

    @get:ConfigItem(
        keyName = "overlayColor",
        name = "Overlay Color",
        description = "Color of Agility overlay",
        position = 5
    )
    @get:Alpha
    val overlayColor: Color?
        get() = Color.GREEN

    @ConfigItem(
        keyName = "highlightMarks",
        name = "Highlight Marks of Grace",
        description = "Enable/disable the highlighting of retrievable Marks of Grace",
        position = 6
    )
    fun highlightMarks(): Boolean {
        return true
    }

    @get:ConfigItem(
        keyName = "markHighlight",
        name = "Mark Highlight Color",
        description = "Color of highlighted Marks of Grace",
        position = 7
    )
    @get:Alpha
    val markColor: Color?
        get() = Color.RED

    @ConfigItem(
        keyName = "highlightPortals",
        name = "Highlight Portals",
        description = "Enable/disable the highlighting of Prifddinas portals",
        position = 8
    )
    fun highlightPortals(): Boolean {
        return true
    }

    @get:ConfigItem(
        keyName = "portalsHighlight",
        name = "Portals Color",
        description = "Color of highlighted Prifddinas portals",
        position = 9
    )
    @get:Alpha
    val portalsColor: Color?
        get() = Color.MAGENTA

    @ConfigItem(
        keyName = "highlightShortcuts",
        name = "Highlight Agility Shortcuts",
        description = "Enable/disable the highlighting of Agility shortcuts",
        position = 10
    )
    fun highlightShortcuts(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "trapOverlay",
        name = "Show Trap Overlay",
        description = "Enable/disable the highlighting of traps on Agility courses",
        position = 11
    )
    fun showTrapOverlay(): Boolean {
        return true
    }

    @get:ConfigItem(
        keyName = "trapHighlight",
        name = "Trap Overlay Color",
        description = "Color of Agility trap overlay",
        position = 12
    )
    @get:Alpha
    val trapColor: Color?
        get() = Color.RED

    @ConfigItem(
        keyName = "agilityArenaNotifier",
        name = "Agility Arena notifier",
        description = "Notify on ticket location change in Agility Arena",
        position = 13
    )
    fun notifyAgilityArena(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "agilityArenaTimer",
        name = "Agility Arena timer",
        description = "Configures whether Agility Arena timer is displayed",
        position = 14
    )
    fun showAgilityArenaTimer(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "highlightStick",
        name = "Highlight Stick",
        description = "Highlight the retrievable stick in the Werewolf Agility Course",
        position = 15
    )
    fun highlightStick(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "stickHighlightColor",
        name = "Stick Highlight Color",
        description = "Color of highlighted stick",
        position = 16
    )
    fun stickHighlightColor(): Color? {
        return Color.RED
    }

    @ConfigItem(
        keyName = "highlightSepulchreNpcs",
        name = "Highlight Projectiles",
        description = "Highlights arrows and swords in the Sepulchre",
        position = 17,
        section = sepulchreSection
    )
    fun highlightSepulchreNpcs(): Boolean {
        return true
    }

    @Alpha
    @ConfigItem(
        keyName = "sepulchreHighlightColor",
        name = "Projectile Color",
        description = "Overlay color for arrows and swords",
        position = 18,
        section = sepulchreSection
    )
    fun sepulchreHighlightColor(): Color? {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "highlightSepulchreObstacles",
        name = "Highlight Obstacles",
        description = "Highlights pillars and stairs in the Sepulchre",
        position = 19,
        section = sepulchreSection
    )
    fun highlightSepulchreObstacles(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "highlightSepulchreSkilling",
        name = "Highlight Skill Challenges",
        description = "Highlights skilling challenges in the Sepulchre",
        position = 20,
        section = sepulchreSection
    )
    fun highlightSepulchreSkilling(): Boolean {
        return true
    }

    companion object {
        @ConfigSection(
            name = "Hallowed Sepulchre",
            description = "Settings for Hallowed Sepulchre highlights",
            position = 17
        )
        const val sepulchreSection = "Hallowed Sepulchre"
    }
}
