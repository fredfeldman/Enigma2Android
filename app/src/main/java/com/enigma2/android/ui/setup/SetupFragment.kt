package com.enigma2.android.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.enigma2.android.R
import com.enigma2.android.data.model.DeviceProfile
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.main.MainActivity
import com.google.android.material.textfield.TextInputEditText

class SetupFragment : Fragment() {

    private lateinit var prefs: ReceiverPreferences
    private var editingProfileId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_setup, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())
        editingProfileId = arguments?.getString(ARG_PROFILE_ID)

        val etName = view.findViewById<TextInputEditText>(R.id.et_device_name)
        val etHost = view.findViewById<TextInputEditText>(R.id.et_host)
        val etPort = view.findViewById<TextInputEditText>(R.id.et_port)
        val etUser = view.findViewById<TextInputEditText>(R.id.et_username)
        val etPassword = view.findViewById<TextInputEditText>(R.id.et_password)
        val etMac = view.findViewById<TextInputEditText>(R.id.et_mac_address)
        val cbHttps = view.findViewById<CheckBox>(R.id.cb_https)
        val btnConnect = view.findViewById<Button>(R.id.btn_connect)
        val btnCancel = view.findViewById<Button>(R.id.btn_cancel)

        // Pre-fill if editing
        editingProfileId?.let { id ->
            prefs.deviceProfiles.find { it.id == id }?.let { profile ->
                etName.setText(profile.name)
                etHost.setText(profile.host)
                etPort.setText(profile.port.toString())
                etUser.setText(profile.username)
                etPassword.setText(profile.password)
                etMac.setText(profile.macAddress)
                cbHttps.isChecked = profile.useHttps
            }
        } ?: run {
            etPort.setText("80")
        }

        btnConnect.setOnClickListener {
            val host = etHost.text?.toString()?.trim() ?: ""
            val portStr = etPort.text?.toString()?.trim() ?: "80"
            val name = etName.text?.toString()?.trim().let {
                if (it.isNullOrBlank()) host else it
            }

            if (host.isBlank()) {
                Toast.makeText(requireContext(), R.string.error_host_required, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val port = portStr.toIntOrNull() ?: 80
            val profile = DeviceProfile(
                id = editingProfileId ?: java.util.UUID.randomUUID().toString(),
                name = name,
                host = host,
                port = port,
                useHttps = cbHttps.isChecked,
                username = etUser.text?.toString()?.trim() ?: "",
                password = etPassword.text?.toString() ?: "",
                macAddress = etMac.text?.toString()?.trim() ?: ""
            )

            prefs.addOrUpdateProfile(profile)
            if (editingProfileId == null || prefs.activeDeviceId.isBlank()) {
                prefs.activeDeviceId = profile.id
            }

            (activity as? MainActivity)?.switchToDevice(profile.id)
        }

        btnCancel.setOnClickListener {
            if (prefs.isConfigured()) {
                parentFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        private const val ARG_PROFILE_ID = "profile_id"

        fun newInstance(profileId: String? = null) = SetupFragment().apply {
            arguments = Bundle().apply {
                profileId?.let { putString(ARG_PROFILE_ID, it) }
            }
        }
    }
}
