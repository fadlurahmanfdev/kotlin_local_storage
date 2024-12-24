package com.fadlurahmanfdev.local_storage

import android.content.Context
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

open class FeatureSharedPreference(private val context: Context) {
    private val preference = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    private val editor = preference.edit()

    open fun saveString(key: String, value: String): Boolean {
        return editor.putString(key, value).commit()
    }

    open fun getString(key: String, defValue: String?): String? {
        return preference.getString(key, defValue)
    }

    open fun saveStringSet(key: String, values: Set<String>): Boolean {
        return editor.putStringSet(key, values).commit()
    }

    open fun getStringSet(key: String, defValues: Set<String>): Set<String>? {
        return preference.getStringSet(key, defValues)
    }

    open fun saveBoolean(key: String, value: Boolean): Boolean {
        return editor.putBoolean(key, value).commit()
    }

    open fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preference.getBoolean(key, defValue)
    }

    open fun saveInt(key: String, value: Int): Boolean {
        return editor.putInt(key, value).commit()
    }

    open fun getInt(key: String, defValue: Int): Int {
        return preference.getInt(key, defValue)
    }

    open fun saveLong(key: String, value: Long): Boolean {
        return editor.putLong(key, value).commit()
    }

    open fun getLong(key: String, defValue: Long): Long {
        return preference.getLong(key, defValue)
    }

    open fun saveFloat(key: String, value: Float): Boolean {
        return editor.putFloat(key, value).commit()
    }

    open fun getFloat(key: String, defValue: Float): Float {
        return preference.getFloat(key, defValue)
    }

    open fun <T> saveObjectSerialization(key: String, value: T, serializer:KSerializer<T>): Boolean {
        val encodedString = Json.encodeToString(serializer, value)
        return editor.putString(key, encodedString).commit()
    }

    open fun <T> getObjectSerialization(key: String, serializer: KSerializer<T>): T? {
        val encodedString = preference.getString(key, null) ?: return null
        val decoded = Json.decodeFromString(serializer,encodedString)
        return decoded
    }
}