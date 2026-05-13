package com.enigma2.android.util

import com.enigma2.android.data.model.Timer

/**
 * Lightweight overlap detection for timers. Two timers conflict when their
 * [begin, end) intervals overlap. We don't try to compute "tuner count" — that
 * is hard to derive reliably across images — but we surface the count of
 * overlapping timers so the user can decide.
 */
object TimerConflictDetector {

    data class Conflict(val timer: Timer)

    fun findConflicts(beginSec: Long, endSec: Long, existing: List<Timer>): List<Conflict> {
        return existing
            .filter { it.beginTimestamp < endSec && it.endTimestamp > beginSec }
            .map { Conflict(it) }
    }
}
