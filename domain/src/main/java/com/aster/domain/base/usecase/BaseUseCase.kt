package com.aster.domain.base.usecase

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.annotation.DispatcherMain
import com.aster.domain.base.Result
import kotlinx.coroutines.*
import kotlin.Exception

/**
 * @author ichsanachmad
 */
abstract class BaseUseCase<P, R>(
    @DispatcherIO private val threadExecutor: CoroutineDispatcher,
    @DispatcherMain private val postExecutor: CoroutineDispatcher
) : CoroutineScope by CoroutineScope(threadExecutor) {

    protected abstract suspend fun buildUseCase(params: P): Result<R>

    private val supervisorJob = SupervisorJob()

    fun invoke(param: P, onSuccess: (result: R) -> Unit, onError: (e: Exception) -> Unit) {
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            launch {
                onError(Exception(throwable))
            }
        }

        launch(errorHandler + supervisorJob) {
            when (val result = buildUseCase(param)) {
                is Result.Success -> {
                    withContext(postExecutor) {
                        result.data?.let {
                            onSuccess(it)
                        }
                    }
                }

                is Result.Error -> {
                    withContext(postExecutor) {
                        onError(result.exception)
                    }
                }
            }
        }
    }

    fun dispose() {
        supervisorJob.cancelChildren()
    }
}