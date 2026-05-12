package com.enigma2.android.ui.bouqueteditor

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Process-wide signal that the receiver's bouquet/channel layout has changed
 * and any cached channel data should be invalidated.
 */
object BouquetEditorEvents {
    private val dirty = AtomicBoolean(false)

    fun markDirty() { dirty.set(true) }

    /** Returns true exactly once after a [markDirty]. */
    fun consumeDirty(): Boolean = dirty.getAndSet(false)
}
