package com.aster.domain.user

import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface UserRepository {
    suspend fun setName(name: String)
    suspend fun getName(): Flow<String>
}