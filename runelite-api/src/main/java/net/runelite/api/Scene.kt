/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

/**
 * Represents the entire 3D scene
 */
interface Scene {
    /**
     * Gets the tiles in the scene
     *
     * @return a 4x104x104 array of tiles in [plane][x][y]
     */
    val tiles: Array<Array<Array<Tile?>?>?>

    /**
     * Get the extended scene. This is larger than 104x104, and its size is [Constants.EXTENDED_SCENE_SIZE].
     */
    val extendedTiles: Array<Array<Array<Tile?>?>?>?

    /**
     * Get the extended tile settings. This is larger than 104x104, and its size is [Constants.EXTENDED_SCENE_SIZE].
     */
    val extendedTileSettings: Array<Array<ByteArray?>?>?
    var drawDistance: Int
    /**
     * Get the minimum scene level which will be rendered
     *
     * @return the plane of the minimum level
     */
    /**
     * Set the minimum scene level which will be rendered
     *
     * @param minLevel the plane of the minimum level
     */
    var minLevel: Int

    /**
     * Remove a tile from the scene
     * @param tile
     */
    fun removeTile(tile: Tile?)

    /**
     * Remove a game object from the scene
     * @param gameObject
     */
    fun removeGameObject(gameObject: GameObject?)
    fun generateHouses()
    fun setRoofRemovalMode(flags: Int)

    /**
     * Get the underlay ids for the scene. The value stored is id + 1, with 0 for no underlay.
     * @return
     */
    val underlayIds: Array<Array<ShortArray?>?>?

    /**
     * Get the overlay ids for the scene. The value stored is id + 1, with 0 for no overlay.
     * @return
     */
    val overlayIds: Array<Array<ShortArray?>?>?

    /**
     * Get the shapes of the tiles for the scene.
     * @return
     */
    val tileShapes: Array<Array<ByteArray?>?>?

    /**
     * Get the heights of the tiles on the scene.
     * @return
     */
    val tileHeights: Array<Array<IntArray?>?>?

    /**
     * Returns the x-axis base coordinate.
     *
     *
     * This value is the x-axis world coordinate of tile (0, 0) in
     * this scene (ie. the bottom-left most coordinates in the scene).
     *
     * @return the base x-axis coordinate
     */
    val baseX: Int

    /**
     * Returns the y-axis base coordinate.
     *
     *
     * This value is the y-axis world coordinate of tile (0, 0) in
     * this scene (ie. the bottom-left most coordinates in the scene).
     *
     * @return the base y-axis coordinate
     */
    val baseY: Int

    /**
     * Check if this scene is an instance
     * @see .getInstanceTemplateChunks
     * @return
     */
    val isInstance: Boolean

    /**
     * Contains a 3D array of template chunks for instanced areas.
     *
     *
     * The array returned is of format [z][x][y], where z is the
     * plane, x and y the x-axis and y-axis coordinates of a tile
     * divided by the size of a chunk.
     *
     *
     * The bits of the int value held by the coordinates are -1 if there is no data,
     * structured in the following format:
     * <pre>`0                   1                   2                   3
     * 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     * | |rot|     y chunk coord     |    x chunk coord    |pln|       |
     * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    `</pre> *
     * @return the array of instance template chunks
     * @see Constants.CHUNK_SIZE
     *
     * @see InstanceTemplates
     */
    val instanceTemplateChunks: Array<Array<IntArray?>?>?

    companion object
}
