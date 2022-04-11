package com.aster.domain.user.interactor

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.annotation.DispatcherMain
import com.aster.domain.base.NoParams
import com.aster.domain.base.Result
import com.aster.domain.base.usecase.BaseUseCase
import com.aster.domain.user.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class SetUserName @Inject constructor(
    @DispatcherIO private val threadExecutor: CoroutineDispatcher,
    @DispatcherMain private val postExecutor: CoroutineDispatcher,
    private val userRepository: UserRepository
) : BaseUseCase<String, NoParams>(threadExecutor, postExecutor) {

    override suspend fun buildUseCase(params: String): Result<NoParams> {
        return try {
            userRepository.setName(name = params)
            Result.Success(NoParams)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}