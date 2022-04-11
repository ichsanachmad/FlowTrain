package com.aster.data.user

import com.aster.data.base.source.DataSource
import com.aster.domain.user.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class UserEntityRepository @Inject constructor(private val userDataFactory: UserDataFactory) :
    UserRepository {
    override suspend fun setName(name: String) {
        userLocalDataFactory.setUserName(name)
    }

    override suspend fun getName(): Flow<String> = userLocalDataFactory.getUserName()

    private val userLocalDataFactory by lazy { userDataFactory.generateDataSource(DataSource.LOCAL) }
}