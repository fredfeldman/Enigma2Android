package com.enigma2.android.util

import com.enigma2.android.data.model.EpgEvent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * Minimal XMLTV writer for a single channel's EPG list. Output validates
 * against `tv_grab_*` parsers for basic programme blocks. We keep this
 * dependency-free (no XML library) — the data we write is simple enough.
 */
object XmltvWriter {

    private val xmltvFormat: SimpleDateFormat by lazy {
        SimpleDateFormat("yyyyMMddHHmmss Z", Locale.US).apply {
            timeZone = TimeZone.getDefault()
        }
    }

    fun write(channelId: String, channelName: String, events: List<EpgEvent>): String {
        val sb = StringBuilder()
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
        sb.append("<!DOCTYPE tv SYSTEM \"xmltv.dtd\">\n")
        sb.append("<tv generator-info-name=\"Enigma2Android\">\n")
        sb.append("  <channel id=\"")
            .append(escape(channelId)).append("\">\n")
        sb.append("    <display-name>")
            .append(escape(channelName)).append("</display-name>\n")
        sb.append("  </channel>\n")
        for (e in events) {
            val startMs = e.beginTimestamp * 1000L
            val endMs = startMs + e.durationSeconds * 1000L
            sb.append("  <programme channel=\"").append(escape(channelId))
                .append("\" start=\"").append(xmltvFormat.format(Date(startMs)))
                .append("\" stop=\"").append(xmltvFormat.format(Date(endMs)))
                .append("\">\n")
            sb.append("    <title>").append(escape(e.title)).append("</title>\n")
            if (e.shortDesc.isNotBlank())
                sb.append("    <sub-title>").append(escape(e.shortDesc)).append("</sub-title>\n")
            if (e.longDesc.isNotBlank())
                sb.append("    <desc>").append(escape(e.longDesc)).append("</desc>\n")
            sb.append("  </programme>\n")
        }
        sb.append("</tv>\n")
        return sb.toString()
    }

    private fun escape(s: String): String =
        s.replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&apos;")
}
