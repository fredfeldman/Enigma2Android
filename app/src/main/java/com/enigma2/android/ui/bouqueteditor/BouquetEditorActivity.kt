package com.enigma2.android.ui.bouqueteditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enigma2.android.R

/** Shell activity for the Bouquet Editor; hosts [BouquetEditorFragment] and pushes
 *  [BouquetEditFragment] / [AddServicePickerFragment] onto the back stack. */
class BouquetEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bouquet_editor)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.bouquet_editor_container, BouquetEditorFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.bouquet_editor_title)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
        return true
    }
}
