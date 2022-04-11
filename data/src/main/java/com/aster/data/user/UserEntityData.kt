package com.aster.data.user

import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface UserEntityData {
    suspend fun setUserName(name: String)
    suspend fun getUserName(): Flow<String>
}