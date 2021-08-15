package com.dede.nativetools.util

import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.roundToInt


fun displayMetrics(): DisplayMetrics {
    return globalContext.resources.displayMetrics
}

fun setV28NightMode(enable: Boolean) {
    val mode = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        enable -> AppCompatDelegate.MODE_NIGHT_YES
        else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }
    AppCompatDelegate.setDefaultNightMode(mode)
}

val Number.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        displayMetrics()
    ).roundToInt()

val Number.dpf: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        displayMetrics()
    )

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun <T : Preference> PreferenceFragmentCompat.requirePreference(key: CharSequence): T {
    return findPreference(key) as? T
        ?: throw NullPointerException("Preference not found, key: $key")
}

private typealias DialogOnClick = (dialog: DialogInterface) -> Unit

class AlertBuilder(private val builder: AlertDialog.Builder) {

    var isCancelable: Boolean = false
        set(value) {
            builder.setCancelable(value)
        }

    fun positiveButton(@StringRes textId: Int, onClick: DialogOnClick? = null) {
        builder.setPositiveButton(textId) { dialog, _ ->
            onClick?.invoke(dialog)
        }
    }

    fun neutralButton(@StringRes textId: Int, onClick: DialogOnClick? = null) {
        builder.setNeutralButton(textId) { dialog, _ ->
            onClick?.invoke(dialog)
        }
    }

    fun negativeButton(@StringRes textId: Int, onClick: DialogOnClick? = null) {
        builder.setNegativeButton(textId) { dialog, _ ->
            onClick?.invoke(dialog)
        }
    }

}

fun Context.alert(
    @StringRes titleId: Int,
    @StringRes messageId: Int,
    init: (AlertBuilder.() -> Unit)? = null
) {
    val builder = MaterialAlertDialogBuilder(this)
        .setTitle(titleId)
        .setMessage(messageId)
    init?.invoke(AlertBuilder(builder))
    builder.show()
}
