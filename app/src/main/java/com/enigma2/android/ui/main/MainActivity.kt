package com.enigma2.android.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.enigma2.android.R
import com.enigma2.android.data.api.ApiClient
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.channels.ChannelsFragment
import com.enigma2.android.ui.devices.DevicePickerFragment
import com.enigma2.android.ui.setup.SetupFragment
import com.enigma2.android.worker.TimerPollingWorker
import java.util.concurrent.TimeUnit

class MainActivity : FragmentActivity() {

    private lateinit var prefs: ReceiverPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = ReceiverPreferences(this)

        if (savedInstanceState == null) {
            if (prefs.isConfigured()) {
                ApiClient.initialize(prefs)
                showChannels()
                scheduleTimerPolling()
            } else {
                showSetup()
            }
        }
    }

    fun showSetup() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, SetupFragment.newInstance())
            .commit()
    }

    fun showChannels() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChannelsFragment())
            .commit()
    }

    fun showDevicePicker() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DevicePickerFragment())
            .addToBackStack(null)
            .commit()
    }

    fun switchToDevice(deviceId: String) {
        prefs.activeDeviceId = deviceId
        ApiClient.initialize(prefs)
        // Clear the back stack and show channels fresh
        supportFragmentManager.popBackStack(null,
            androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        showChannels()
    }

    private fun scheduleTimerPolling() {
        val workRequest = PeriodicWorkRequestBuilder<TimerPollingWorker>(15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "timer_polling",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }
}
