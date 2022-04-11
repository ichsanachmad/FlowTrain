package com.aster.domain.user.interactor

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.base.NoParams
import com.aster.domain.base.Result
import com.aster.domain.base.usecase.FlowUseCase
import com.aster.domain.user.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Achmad Ichsan (achmad.ichsan@dana.id)
 * @version GetUserName, v 0.1 11/04/22 14.52 by Achmad Ichsan
 */
class GetUserName @Inject constructor(
    @DispatcherIO threadExecutor: CoroutineDispatcher,
    private val userRepository: UserRepository
) :
    FlowUseCase<NoParams, String>(threadExecutor) {
    override suspend fun buildUseCase(params: NoParams): Flow<Result<String>> {
        return userRepository.getName()
    }
}