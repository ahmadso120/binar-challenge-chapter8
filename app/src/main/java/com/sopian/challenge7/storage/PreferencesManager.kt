package com.sopian.challenge7.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "challenge8")

class PreferencesManager(context: Context) {

    private val appContext = context.applicationContext

    fun isLoggedIn(): Flow<Boolean> {
        return appContext.dataStore.data.map {
            it[IS_LOGGED_IN] ?: false
        }
    }

    fun getUserEmail(): Flow<String> {
        return appContext.dataStore.data.map {
            it[EMAIL] ?: ""
        }
    }

    suspend fun setUserLoggedIn(userLoggedIn: UserLoggedIn) {
        appContext.dataStore.edit {
            it[IS_LOGGED_IN] = userLoggedIn.isLoggedIn
            it[EMAIL] = userLoggedIn.email
        }
    }

    suspend fun clearUserLoggedIn() {
        appContext.dataStore.edit {
            it.remove(IS_LOGGED_IN)
            it.remove(EMAIL)
        }
    }

    data class UserLoggedIn(
        val isLoggedIn: Boolean,
        val email: String
    )

    companion object {
        private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        private val EMAIL = stringPreferencesKey("email")
    }
}