package com.enigma2.android.data.prefs

import android.content.Context
import java.security.MessageDigest

/**
 * Local-only PIN to gate the in-app Parental screen. This is *not* the receiver
 * setup PIN — the receiver enforces its own. Hash is SHA-256, stored in shared prefs.
 */
class ParentalAppLockStore(context: Context) {
    private val prefs = context.applicationContext
        .getSharedPreferences("parental_app_lock", Context.MODE_PRIVATE)

    fun isEnabled(): Boolean = prefs.contains(KEY_HASH)

    fun set(pin: String) {
        prefs.edit().putString(KEY_HASH, hash(pin)).apply()
    }

    fun clear() {
        prefs.edit().remove(KEY_HASH).apply()
    }

    fun verify(pin: String): Boolean {
        val stored = prefs.getString(KEY_HASH, null) ?: return true
        return stored == hash(pin)
    }

    private fun hash(pin: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val bytes = md.digest(pin.toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }

    companion object {
        private const val KEY_HASH = "pin_hash"
    }
}
