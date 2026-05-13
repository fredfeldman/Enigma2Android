package com.enigma2.android.ui.receiversettings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enigma2.android.R

/** Single-activity host for all Receiver Settings sub-screens. */
class ReceiverSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_settings)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.receiver_settings_container, ReceiverSettingsRootFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.receiver_settings_title)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStack()
        else finish()
        return true
    }

    fun pushFragment(fragment: androidx.fragment.app.Fragment, title: CharSequence) {
        supportActionBar?.title = title
        supportFragmentManager.beginTransaction()
            .replace(R.id.receiver_settings_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            supportActionBar?.setTitle(R.string.receiver_settings_title)
        }
    }
}
