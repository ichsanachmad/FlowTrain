package com.aster.data.user

import com.aster.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author ichsanachmad
 */
interface UserEntityData {
    suspend fun setUserName(name: String)
    suspend fun getUserName(): Flow<Result<String>>
}