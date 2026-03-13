package com.enigma2.android.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enigma2.android.R

class HideBouquetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_bouquets)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.hide_bouquets_container, HideBouquetsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
