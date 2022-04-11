package com.aster.data.base.mapper

import com.aster.domain.base.Result
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf

/**
 * @author ichsanachmad
 */

@FlowPreview
inline fun <T, R> Flow<Result<T>>.mapResultFlow(crossinline transform: (res: T?) -> R): Flow<Result<R>> {
    return flatMapConcat {
        when (it) {
            is Result.Initial -> flowOf(it)
            is Result.Success -> flowOf(Result.Success(transform(it.data)))
            is Result.Error -> flowOf(it)
            is Result.Loading -> flowOf(it)
        }
    }
}