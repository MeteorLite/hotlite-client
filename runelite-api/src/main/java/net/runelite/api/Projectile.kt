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

/**
 * Represents a projectile entity. (ie. cannonball, arrow)
 */
interface Projectile : Renderable {
    /**
     * Gets the ID of the projectile.
     *
     * @return the projectile ID
     * @see GraphicID
     */
    val id: Int

    /**
     * Gets the actor that is targeted by this projectile.
     *
     * @return the target actor, or null if this projectile is an AoE attack
     */
    val interacting: Actor?

    /**
     * Get the target point of the projectile. For projectiles with an actor target,
     * this is updated each frame to the actor position.
     *
     * @return
     */
    val target: LocalPoint?

    /**
     * Gets the original x-axis coordinate that this projectile started from.
     *
     * @return the original coordinate
     */
    val x1: Int

    /**
     * Gets the original y-axis coordinate that this projectile started from.
     *
     * @return the original coordinate
     */
    val y1: Int

    /**
     * Gets the plane that the projectile is on.
     *
     * @return the plane
     */
    val floor: Int

    /**
     * Gets the height of the projectile.
     *
     * @return the height
     */
    val height: Int

    /**
     * Gets the ending height of the projectile.
     *
     * @return the ending height
     */
    val endHeight: Int

    /**
     * Gets the game cycle that the projectile begun movement at.
     *
     * @return the start game cycle
     */
    val startCycle: Int
    /**
     * Gets the game cycle that the projectile will reach its target at.
     *
     * @return the end game cycle
     */
    /**
     * Sets the game cycle the projectile will reach its target at. The
     * projectile automatically despawns after this time, and setting the
     * end cycle to a time in the past is an effective way of removing the
     * projectile.
     * @param cycle
     */
    var endCycle: Int

    /**
     * Gets the remaining game cycles until the projectile reaches its
     * target and despawns.
     *
     * @return the remaining game cycles
     */
    val remainingCycles: Int

    /**
     * Gets the slope of the projectile.
     *
     *
     * This value indicates how much arc the projectile can have. Projectiles
     * with larger slopes have a more noticeable arc when thrown.
     *
     * @return the slope of the projectile
     */
    val slope: Int

    /**
     * Gets the starting height of the projectile.
     *
     * @return the starting height
     */
    val startHeight: Int

    /**
     * Gets the current x-axis coordinate of the projectile.
     *
     * @return the x-axis coordinate
     */
    val x: Double

    /**
     * Gets the current y-axis coordinate of the projectile.
     *
     * @return the y-axis coordinate
     */
    val y: Double

    /**
     * Gets the current z-axis coordinate of the projectile.
     *
     * @return the z-axis coordinate
     */
    val z: Double

    /**
     * Gets the scalar quantity (speed) at which the projectile is travelling.
     *
     * @return the scalar quantity
     */
    val scalar: Double

    /**
     * Gets the x-axis velocity of the projectile.
     *
     * @return the x-axis velocity
     */
    val velocityX: Double

    /**
     * Gets the y-axis velocity of the projectile.
     *
     * @return the y-axis velocity
     */
    val velocityY: Double

    /**
     * Gets the z-axis velocity of the projectile.
     *
     * @return the z-axis velocity
     */
    val velocityZ: Double

    /**
     * The animation of the projectile
     * @return
     */
    val animation: Animation?

    /**
     * The frame of the current animation
     * @return
     */
    val animationFrame: Int

    companion object
}
