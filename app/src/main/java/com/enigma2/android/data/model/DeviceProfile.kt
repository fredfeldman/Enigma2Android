package com.enigma2.android.data.model

import java.util.UUID

data class DeviceProfile(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val host: String = "",
    val port: Int = 80,
    val useHttps: Boolean = false,
    val username: String = "",
    val password: String = "",
    val macAddress: String = ""
)
