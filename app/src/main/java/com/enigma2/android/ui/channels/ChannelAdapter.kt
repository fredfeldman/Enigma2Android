package com.enigma2.android.ui.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.enigma2.android.R
import com.enigma2.android.data.model.NowNextEvent
import com.enigma2.android.data.model.Service
import com.enigma2.android.data.prefs.ReceiverPreferences

class ChannelAdapter(
    private val prefs: ReceiverPreferences,
    private val onChannelClick: (Service) -> Unit,
    private val onChannelLongClick: (Service) -> Boolean
) : ListAdapter<Service, ChannelAdapter.ViewHolder>(DIFF) {

    private var favoriteRefs: Set<String> = emptySet()
    private var recordingRefs: Set<String> = emptySet()
    private var nowNextMap: Map<String, NowNextEvent> = emptyMap()

    fun updateFavorites(favs: List<String>) {
        favoriteRefs = favs.toSet()
        notifyItemRangeChanged(0, itemCount)
    }

    fun updateRecordingRefs(refs: Set<String>) {
        recordingRefs = refs
        notifyItemRangeChanged(0, itemCount)
    }

    fun updateNowNext(events: List<NowNextEvent>) {
        nowNextMap = events.associateBy { it.sref }
        notifyItemRangeChanged(0, itemCount)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber: TextView = view.findViewById(R.id.tv_channel_number)
        val ivPicon: ImageView = view.findViewById(R.id.iv_picon)
        val tvName: TextView = view.findViewById(R.id.tv_channel_name)
        val tvNow: TextView = view.findViewById(R.id.tv_now_title)
        val tvNext: TextView = view.findViewById(R.id.tv_next_title)
        val progressNow: ProgressBar = view.findViewById(R.id.progress_now)
        val tvRecBadge: TextView = view.findViewById(R.id.tv_rec_badge)
        val btnFavorite: TextView = view.findViewById(R.id.btn_favorite)

        init {
            view.setOnClickListener {
                onChannelClick(getItem(bindingAdapterPosition))
            }
            view.setOnLongClickListener {
                onChannelLongClick(getItem(bindingAdapterPosition))
            }
            // Favorite button clickable directly for tablet touch
            btnFavorite.setOnClickListener {
                val service = getItem(bindingAdapterPosition)
                prefs.toggleFavorite(service.ref)
                favoriteRefs = prefs.favorites.toSet()
                notifyItemChanged(bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = getItem(position)
        holder.tvNumber.text = (position + 1).toString()
        holder.tvName.text = service.name

        // Picon: try path from API, then two fallback URL formats
        val piconReq = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.ic_channel_placeholder)
            .error(R.drawable.ic_channel_placeholder)

        val piconUrl = if (!service.piconPath.isNullOrBlank()) {
            prefs.piconUrlFromPath(service.piconPath)
        } else {
            prefs.piconUrl(service.ref)
        }

        Glide.with(holder.itemView.context)
            .load(piconUrl)
            .apply(piconReq)
            .error(
                Glide.with(holder.itemView.context)
                    .load(prefs.piconUrlAlt1(service.ref))
                    .apply(piconReq)
            )
            .into(holder.ivPicon)

        // NowNext
        val nn = nowNextMap[service.ref]
        if (nn != null) {
            holder.tvNow.text = nn.nowTitle
            holder.tvNow.visibility = View.VISIBLE
            val nowSec = System.currentTimeMillis() / 1000
            val elapsed = (nowSec - nn.nowBegin).toInt().coerceAtLeast(0)
            val progress = if (nn.nowDuration > 0) (elapsed * 100 / nn.nowDuration) else 0
            holder.progressNow.progress = progress.coerceIn(0, 100)
            holder.progressNow.visibility = View.VISIBLE
            if (nn.nextTitle.isNotBlank()) {
                holder.tvNext.text = "Next: ${nn.nextTitle}"
                holder.tvNext.visibility = View.VISIBLE
            } else {
                holder.tvNext.visibility = View.GONE
            }
        } else {
            holder.tvNow.visibility = View.GONE
            holder.progressNow.visibility = View.GONE
            holder.tvNext.visibility = View.GONE
        }

        // Recording badge
        holder.tvRecBadge.visibility = if (service.ref in recordingRefs) View.VISIBLE else View.GONE

        // Favorite star
        holder.btnFavorite.text = if (service.ref in favoriteRefs) "★" else "☆"
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Service>() {
            override fun areItemsTheSame(a: Service, b: Service) = a.ref == b.ref
            override fun areContentsTheSame(a: Service, b: Service) = a == b
        }
    }
}
