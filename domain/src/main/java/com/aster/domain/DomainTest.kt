package com.aster.domain

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.base.Result
import com.aster.domain.base.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
class DomainTest @Inject constructor(
    @DispatcherIO private val threadExecutor: CoroutineDispatcher
) : FlowUseCase<String, String>(threadExecutor) {
    override fun buildUseCase(params: String): Flow<Result<String>> {
        return flow {
            when (params) {
                "a" -> emit(Result.Success("a"))
            }
        }
    }
}