package com.aster.data.user.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.aster.data.user.UserEntityData
import com.aster.domain.base.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author ichsanachmad
 */
@Singleton
class UserLocalRepository @Inject constructor(@ApplicationContext private val context: Context) :
    UserEntityData {

    companion object {
        private const val USER_PREF = "user_preference"
        private const val USER_NAME_KEY = "user_name_key"
        private val Context.userDataStore by preferencesDataStore(name = USER_PREF)
    }

    private val userNamePrefKey = stringPreferencesKey(USER_NAME_KEY)

    override suspend fun setUserName(name: String) {
        context.userDataStore.edit {
            it[userNamePrefKey] = name
        }
    }

    override suspend fun getUserName(): Flow<Result<String>> =
        context.userDataStore.data.map { Result.Success(it[userNamePrefKey] ?: "") }

}