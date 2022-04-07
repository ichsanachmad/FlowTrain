package com.aster.domain.base.usecase

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.annotation.DispatcherMain
import com.aster.domain.base.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

/**
 * @author ichsanachmad
 */
abstract class FlowUseCase<P, R> (
    @DispatcherIO private val threadExecutor: CoroutineDispatcher
) : CoroutineScope by CoroutineScope(threadExecutor) {

    protected abstract suspend fun buildUseCase(params: P): Flow<Result<R>>

    suspend fun execute(params: P): Flow<Result<R>> =
        buildUseCase(params)
            .catch { e -> emit(Result.Error(Exception(e))) }
            .flowOn(threadExecutor)
}