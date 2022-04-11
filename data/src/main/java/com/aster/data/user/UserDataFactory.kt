package com.aster.data.user

import com.aster.data.base.factory.DataSourceFactory
import com.aster.data.base.source.DataSource
import com.aster.data.user.local.UserLocalRepository
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class UserDataFactory @Inject constructor(private val userLocalRepository: UserLocalRepository) :
    DataSourceFactory<UserEntityData> {

    override fun generateDataSource(dataSource: String): UserEntityData {
        return when (dataSource) {
            DataSource.LOCAL -> userLocalRepository
            else -> throw IllegalStateException()
        }
    }
}