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

import java.awt.Shape

/**
 * Represents a game object.
 *
 *
 * Most object in the RuneScape world are considered as game objects. Things
 * such as trees, anvils, boxes, etc are all game objects.
 */
interface GameObject : TileObject {
    /**
     * Get the size of this object, in tiles, on the x axis
     *
     * @return
     */
    fun sizeX(): Int

    /**
     * Get the size of this object, in tiles, on the y axis
     *
     * @return
     */
    fun sizeY(): Int

    /**
     * Gets the minimum x and y scene coordinate pair for this game object.
     *
     * @return the minimum scene coordinate
     */
    val sceneMinLocation: Point?

    /**
     * Gets the maximum x and y scene coordinate pair for this game object.
     *
     *
     * This value differs from [.getSceneMinLocation] when the size
     * of the object is more than 1 tile.
     *
     * @return the maximum scene coordinate
     */
    val sceneMaxLocation: Point?

    /**
     * Gets the convex hull of the object's model.
     *
     * @return the convex hull
     * @see net.runelite.api.model.Jarvis
     */
    val convexHull: Shape?

    /**
     * Get the orientation of the object
     * @see net.runelite.api.coords.Angle
     *
     * @return
     */
    val orientation: Int
    val renderable: Renderable?

    /**
     * Gets the orientation of the model in JAU.
     * This is typically 0 for non-actors, since
     * most object's models are oriented prior to
     * lighting during scene loading. See [.getOrientation]
     * instead for object orientation.
     *
     * @see net.runelite.api.coords.Angle
     */
    val modelOrientation: Int

    /**
     * A bitfield containing various flags:
     * <pre>`object type = bits & 31
     * orientation = bits >>> 6 & 3
     * supports items = bits >>> 8 & 1
    `</pre> *
     */
    val config: Int

    companion object
}
