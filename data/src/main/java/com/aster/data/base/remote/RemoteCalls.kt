package com.aster.data.base.remote

import com.aster.domain.base.Result
import com.aster.domain.base.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException
import kotlin.Exception

/**
 * @author ichsanachmad
 */

suspend inline fun <reified T : Any> flowSafeNetworkCall(crossinline response: suspend () -> Response<BaseResponse<T>>): Flow<Result<T>> {
    return flow {
        try {
            when (response().code()) {
                in 200..226,
                in 300..308 -> {
                    emit(Result.Success(response().body()?.articles))
                }
                in 400..451 -> {
                    emit(Result.Error(Exception(response().getError())))
                }
                in 500..511 -> {
                    emit(Result.Error(Exception(response().getError())))
                }

                else -> throw IllegalStateException()
            }
        } catch (e: SocketException) {
            emit(Result.Error(e))
        } catch (e: Exception) {
            when (e) {
                is ConnectException, is UnknownHostException -> {
                    emit(Result.Error(e))
                }
                else -> throw e
            }
        }
    }
}

suspend inline fun <reified T : Any> safeNetworkCall(crossinline response: suspend () -> Response<BaseResponse<T>>): Result<T> {
    return try {
        when (response().code()) {
            in 200..226,
            in 300..308 -> {
                Result.Success(response().body()?.articles)
            }
            in 400..451 -> {
                Result.Error(Exception(response().getError()))
            }
            in 500..511 -> {
                Result.Error(Exception(response().getError()))
            }

            else -> throw IllegalStateException()
        }
    } catch (e: SocketException) {
        Result.Error(e)
    } catch (e: Exception) {
        when (e) {
            is ConnectException, is UnknownHostException -> {
                Result.Error(e)
            }
            else -> throw e
        }

    }
}

fun <T> Response<T>.getError(): String {
    return errorBody()?.charStream()?.readText() ?: "Failed to parse error message"
}