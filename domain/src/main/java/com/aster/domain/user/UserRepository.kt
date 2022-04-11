package com.aster.domain.user

import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface UserRepository {
    suspend fun setName(name: String)
    suspend fun getName(): Flow<Result<String>>
}