package org.example.common.json

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

object jsonUtil {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    fun <T> encodeToJson(v: T, serializer : KSerializer<T>): String {
        return json.encodeToString(serializer, v)
    }

    fun <T> decodeFromJson(v : String, serializer: KSerializer<T>): T {
        return json.decodeFromString(serializer, v)
    }
}