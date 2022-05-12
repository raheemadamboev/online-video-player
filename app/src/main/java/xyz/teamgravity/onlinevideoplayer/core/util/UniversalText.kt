package xyz.teamgravity.onlinevideoplayer.core.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UniversalText {

    companion object {
        private const val EMPTY = ""
    }

    data class Dynamic(val value: String) : UniversalText()
    class Resource(@StringRes val id: Int, vararg val args: Any) : UniversalText()
    object Empty : UniversalText()

    @Composable
    fun asString(): String {
        return when (this) {
            is Dynamic -> value
            is Resource -> stringResource(id = id, formatArgs = args)
            Empty -> EMPTY
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is Dynamic -> value
            is Resource -> context.getString(id, *args)
            Empty -> EMPTY
        }
    }
}