package com.dede.nativetools.netspeed

import android.graphics.Typeface
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.dede.nativetools.netspeed.typeface.TypefaceGetter
import com.dede.nativetools.util.get
import com.dede.nativetools.util.globalDataStore
import com.dede.nativetools.util.set

/**
 * NetSpeed配置
 *
 * @author hsh
 * @since 2021/8/10 2:15 下午
 */
object NetSpeedPreferences {

    const val KEY_NET_SPEED_STATUS = "net_speed_status"
    const val KEY_NET_SPEED_INTERVAL = "net_speed_interval"
    const val KEY_NET_SPEED_NOTIFY_CLICKABLE = "net_speed_notify_clickable"
    const val KEY_NET_SPEED_MODE = "net_speed_mode_1"
    const val KEY_NET_SPEED_QUICK_CLOSEABLE = "net_speed_notify_quick_closeable"
    const val KEY_NET_SPEED_USAGE = "net_speed_usage"
    const val KEY_NET_SPEED_HIDE_LOCK_NOTIFICATION = "net_speed_locked_hide"
    const val KEY_NET_SPEED_HIDE_THRESHOLD = "net_speed_hide_threshold"
    const val KEY_NET_SPEED_MIN_UNIT = "net_speed_min_unit"

    const val KEY_NET_SPEED_TEXT_STYLE = "net_speed_text_style"
    const val KEY_NET_SPEED_FONT = "net_speed_font"
    const val KEY_NET_SPEED_VERTICAL_OFFSET = "net_speed_vertical_offset"
    const val KEY_NET_SPEED_HORIZONTAL_OFFSET = "net_speed_horizontal_offset"
    const val KEY_NET_SPEED_RELATIVE_RATIO = "net_speed_relative_ratio"
    const val KEY_NET_SPEED_RELATIVE_DISTANCE = "net_speed_relative_distance"
    const val KEY_NET_SPEED_TEXT_SCALE = "net_speed_text_scale"
    const val KEY_NET_SPEED_HORIZONTAL_SCALE = "net_speed_horizontal_scale"

    private const val KEY_NET_SPEED_AUTO_START = "net_speed_auto_start"
    private const val KEY_NOTIFICATION_DONT_ASK = "notification_dont_ask"
    private const val KEY_PRIVACY_AGREED = "privacy_agreed"
    private const val KEY_MIUI_ALERTED = "miui_alerted"

    const val DEFAULT_INTERVAL = 1000
    const val DEFAULT_TEXT_STYLE = Typeface.BOLD
    const val DEFAULT_FONT = TypefaceGetter.FONT_NORMAL

    const val MODE_DOWN = "0"
    const val MODE_ALL = "1"

    var privacyAgreed: Boolean
        get() = globalDataStore.get(booleanPreferencesKey(KEY_PRIVACY_AGREED), false)
        set(value) = globalDataStore.set(booleanPreferencesKey(KEY_PRIVACY_AGREED), value)

    var status: Boolean
        get() = globalDataStore.get(booleanPreferencesKey(KEY_NET_SPEED_STATUS), false)
        set(value) = globalDataStore.set(booleanPreferencesKey(KEY_NET_SPEED_STATUS), value)

    val autoStart: Boolean
        get() = globalDataStore.get(booleanPreferencesKey(KEY_NET_SPEED_AUTO_START), false)

    var dontAskNotify: Boolean
        get() = globalDataStore.get(booleanPreferencesKey(KEY_NOTIFICATION_DONT_ASK), false)
        set(value) = globalDataStore.set(booleanPreferencesKey(KEY_NOTIFICATION_DONT_ASK), value)

    var miuiAlerted: Boolean
        get() = globalDataStore.get(booleanPreferencesKey(KEY_MIUI_ALERTED), false)
        set(value) = globalDataStore.set(booleanPreferencesKey(KEY_MIUI_ALERTED), value)
}
