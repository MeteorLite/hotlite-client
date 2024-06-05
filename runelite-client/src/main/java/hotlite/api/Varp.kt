package hotlite.api

import net.runelite.api.Client
import net.runelite.client.RuneLite

open class Varp(val id: Int) {
    private var client = RuneLite.getInjector().getInstance(Client::class.java)
    fun getValue() : Int {
        return client.getVarpValue(id)
    }
}