package xyz.teamgravity.onlinevideoplayer.core.util

sealed class Resource<T>(val data: T? = null, val message: UniversalText = UniversalText.Empty) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: UniversalText, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}