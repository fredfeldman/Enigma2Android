package com.enigma2.android.utils

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

object WakeOnLan {

    fun send(macAddress: String) {
        try {
            val hex = macAddress.replace(":", "").replace("-", "")
            if (hex.length != 12) return

            val macBytes = ByteArray(6) { hex.substring(it * 2, it * 2 + 2).toInt(16).toByte() }
            val packet = ByteArray(6 + 16 * 6)
            // 6 bytes of 0xFF
            for (i in 0 until 6) packet[i] = 0xFF.toByte()
            // 16 repetitions of MAC
            for (i in 0 until 16) {
                System.arraycopy(macBytes, 0, packet, 6 + i * 6, 6)
            }

            DatagramSocket().use { socket ->
                socket.setBroadcast(true)
                val address = InetAddress.getByName("255.255.255.255")
                socket.send(DatagramPacket(packet, packet.size, address, 9))
            }
        } catch (e: Exception) {
            // Silent: WoL is best-effort
        }
    }
}
