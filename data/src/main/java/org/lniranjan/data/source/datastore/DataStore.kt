package org.lniranjan.data.source.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lniranjan.data.Constants.USER_PROFILE


class DataStore(private val dataStore: DataStore<Preferences>) {

    val savedUser: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[USER_PROFILE] ?: 0
        }

    suspend fun editUser() {
        dataStore.edit { preferences ->
            val currentValue = preferences[USER_PROFILE] ?: 0
            preferences[USER_PROFILE] = currentValue.inc()
        }
    }
}
