package app.runningcoach

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class SessionHistory(context: Context) {
    private val prefs = context.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    fun sessions(): List<RunRecord> {
        val raw = prefs.getString(KEY_SESSIONS, "[]") ?: "[]"
        val array = JSONArray(raw)
        val records = mutableListOf<RunRecord>()
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            val metres = obj.optDouble("m", Double.NaN)
            records += RunRecord(
                atMillis = obj.getLong("at"),
                kind = SessionKind.valueOf(obj.getString("kind")),
                elapsedMillis = obj.getLong("ms"),
                distanceMeters = if (metres.isNaN()) null else metres,
                summary = obj.getString("summary"),
            )
        }
        return records
    }

    fun add(record: RunRecord) {
        val next = (listOf(record) + sessions()).take(MAX_SESSIONS)
        val array = JSONArray()
        for (item in next) {
            val obj = JSONObject()
            obj.put("at", item.atMillis)
            obj.put("kind", item.kind.name)
            obj.put("ms", item.elapsedMillis)
            if (item.distanceMeters != null) {
                obj.put("m", item.distanceMeters)
            }
            obj.put("summary", item.summary)
            array.put(obj)
        }
        prefs.edit().putString(KEY_SESSIONS, array.toString()).apply()
    }

    var displayName: String
        get() = prefs.getString(KEY_NAME, "") ?: ""
        set(value) {
            prefs.edit().putString(KEY_NAME, value).apply()
        }

    var speechRate: Float
        get() = prefs.getFloat(KEY_RATE, 1.0f)
        set(value) {
            prefs.edit().putFloat(KEY_RATE, value).apply()
        }

    companion object {
        private const val FILE = "coach"
        private const val KEY_SESSIONS = "sessions"
        private const val KEY_NAME = "display_name"
        private const val KEY_RATE = "speech_rate"
        private const val MAX_SESSIONS = 50
    }
}
