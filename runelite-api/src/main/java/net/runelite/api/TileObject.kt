/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api

import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Graphics2D
import java.awt.Polygon
import java.awt.Shape

/**
 * Represents an object on a Tile
 */
interface TileObject {
    /**
     * A bitfield containing various flags:
     * <pre>`(RL) plane = bits >> 60 & 3
     * worldView = bits >> 49 & 2047
     * id = bits >> 17 & 0xffffffff
     * wall = bits >> 16 & 1
     * type = bits >> 14 & 3
     * scene y = bits >> 7 & 127
     * scene x = bits >> 0 & 127
    `</pre> *
     * Type 0 = player, 1 = npc, 2 = game object, 3 = item
     */
    val hash: Long

    /**
     * Gets the x-axis coordinate of the object in local context.
     *
     * @see LocalPoint
     */
    val x: Int

    /**
     * Gets the y-axis coordinate of the object in local context.
     *
     * @see LocalPoint
     */
    val y: Int

    /**
     * Gets the vertical coordinate of this object
     */
    val z: Int

    /**
     * Gets the plane of the tile that the object is on.
     */
    val plane: Int

    /**
     * Gets the WorldView this TileObject is a part of.
     */
    val worldView: WorldView?

    /**
     * Gets the ID of the object.
     *
     * @see ObjectID
     *
     * @see NullObjectID
     */
    val id: Int

    val worldLocation: WorldPoint

    val localLocation: LocalPoint

    /**
     * Calculates the position of the center of this tile on the canvas
     */
    val canvasLocation: Point?

    /**
     * Calculates the position of the center of this tile on the canvas
     *
     * @param zOffset Vertical offset to apply before projection
     */
    fun getCanvasLocation(zOffset: Int): Point?

    /**
     * Creates a polygon outlining the tile this object is on
     */
    val canvasTilePoly: Polygon?

    /**
     * Calculates the canvas point to center `text` above the tile this object is on.
     *
     * @param graphics the graphics to use for font size calculation
     * @param zOffset Vertical offset to apply before projection
     * @return the canvas point to draw the text at
     */
    fun getCanvasTextLocation(graphics: Graphics2D?, text: String?, zOffset: Int): Point?

    /**
     * Gets a point on the canvas of where this objects mini-map indicator
     * should appear.
     *
     * @return mini-map location on canvas
     */
    val minimapLocation: Point?

    /**
     * Calculate the on-screen clickable area of the object.
     */
    val clickbox: Shape?

    companion object {
        const val HASH_PLANE_SHIFT: Int = 60
    }
}
