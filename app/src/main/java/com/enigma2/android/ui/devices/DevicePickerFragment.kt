package com.enigma2.android.ui.devices

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enigma2.android.R
import com.enigma2.android.data.model.DeviceProfile
import com.enigma2.android.data.prefs.ReceiverPreferences
import com.enigma2.android.ui.main.MainActivity
import com.enigma2.android.ui.setup.SetupFragment

class DevicePickerFragment : Fragment() {

    private lateinit var prefs: ReceiverPreferences
    private lateinit var adapter: DeviceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_device_picker, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = ReceiverPreferences(requireContext())

        adapter = DeviceAdapter(
            onDeviceClick = { device -> selectDevice(device) },
            onDeviceLongClick = { device -> showDeviceOptions(device); true }
        )

        val rv = view.findViewById<RecyclerView>(R.id.rv_devices)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        view.findViewById<View>(R.id.btn_back)?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        view.findViewById<View>(R.id.btn_add_device)?.setOnClickListener {
            openSetup(null)
        }

        refreshList()
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun refreshList() {
        adapter.submitList(prefs.deviceProfiles.toList())
        adapter.setActiveId(prefs.activeDeviceId)
    }

    private fun selectDevice(device: DeviceProfile) {
        prefs.activeDeviceId = device.id
        (activity as? MainActivity)?.switchToDevice(device.id)
    }

    private fun showDeviceOptions(device: DeviceProfile) {
        AlertDialog.Builder(requireContext())
            .setTitle(device.name)
            .setItems(arrayOf(getString(R.string.edit), getString(R.string.delete))) { _, which ->
                when (which) {
                    0 -> openSetup(device)
                    1 -> confirmDelete(device)
                }
            }
            .show()
    }

    private fun openSetup(device: DeviceProfile?) {
        val fragment = SetupFragment.newInstance(device?.id)
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun confirmDelete(device: DeviceProfile) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.delete)
            .setMessage(getString(R.string.delete_device_confirm, device.name))
            .setPositiveButton(R.string.delete) { _, _ ->
                prefs.removeProfile(device.id)
                refreshList()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }
}
