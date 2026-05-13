package com.enigma2.android.service

import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi
import com.enigma2.android.data.repository.Enigma2Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Quick-settings tile that toggles the active receiver between standby and on.
 * Uses the `/api/powerstate` endpoint via [Enigma2Repository.setPowerState] with newstate=0
 * (toggle standby).
 */
@RequiresApi(Build.VERSION_CODES.N)
class PowerToggleTileService : TileService() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val repo = Enigma2Repository()

    override fun onStartListening() {
        super.onStartListening()
        refresh()
    }

    override fun onClick() {
        super.onClick()
        val tile = qsTile ?: return
        tile.state = Tile.STATE_UNAVAILABLE
        tile.updateTile()
        scope.launch {
            try {
                repo.setPowerState(0) // toggle standby
                refresh()
            } catch (_: Exception) {
                tile.state = Tile.STATE_INACTIVE
                tile.updateTile()
            }
        }
    }

    private fun refresh() {
        val tile = qsTile ?: return
        scope.launch {
            tile.state = try {
                val ps = repo.getPowerState()
                if (ps.inStandby) Tile.STATE_INACTIVE else Tile.STATE_ACTIVE
            } catch (_: Exception) {
                Tile.STATE_UNAVAILABLE
            }
            tile.updateTile()
        }
    }
}
