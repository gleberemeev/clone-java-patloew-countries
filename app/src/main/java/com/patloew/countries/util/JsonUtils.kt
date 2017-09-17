package com.patloew.countries.util

import android.util.JsonReader
import com.google.gson.stream.JsonToken
import java.io.IOException

/**
 * Created by gleberemeev on 16.09.17.
 */
class JsonUtils {
    companion object {
        @Throws(IOException::class)
        fun readNullSafeString(reader : JsonReader) : String? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextString()
            }
        }

        @Throws(IOException::class)
        fun readNullSafeLong(reader : JsonReader) : Long? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextLong()
            }
        }

        @Throws(IOException::class)
        internal fun readNullSafeInteger(reader: com.google.gson.stream.JsonReader): Int? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextInt()
            }
        }

        @Throws(IOException::class)
        fun readNullSafeDouble(reader: com.google.gson.stream.JsonReader): Double? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextDouble()
            }
        }

        @Throws(IOException::class)
        fun readNullSafeFloat(reader: com.google.gson.stream.JsonReader): Float? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextDouble().toFloat()
            }
        }

        @Throws(IOException::class)
        fun readNullSafeBoolean(reader: com.google.gson.stream.JsonReader): Boolean? {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull()
                return null
            } else {
                return reader.nextBoolean()
            }
        }
    }
}