package com.enigma2.android.data.api

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream

/**
 * Tolerant parser for the BouquetEditor plugin's XML mutation responses.
 * Expected shape: `<e2simplexmlresult><e2state>True</e2state><e2statetext>…</e2statetext></e2simplexmlresult>`.
 * Empty / non-XML bodies are treated as success (some images return HTTP 200 with no payload).
 */
object BouquetEditorXml {

    data class SimpleResult(val ok: Boolean, val message: String?)

    fun parseSimpleResult(stream: InputStream): SimpleResult {
        return try {
            val parser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(stream, null)

            var ok = true
            var message: String? = null
            val text = StringBuilder()
            var event = parser.eventType
            while (event != XmlPullParser.END_DOCUMENT) {
                when (event) {
                    XmlPullParser.START_TAG -> text.setLength(0)
                    XmlPullParser.TEXT -> text.append(parser.text)
                    XmlPullParser.END_TAG -> when (parser.name) {
                        "e2state" -> ok = text.toString().trim().equals("True", ignoreCase = true)
                        "e2statetext" -> message = text.toString().trim()
                    }
                }
                event = parser.next()
            }
            SimpleResult(ok, message)
        } catch (_: Exception) {
            SimpleResult(true, null)
        }
    }
}
