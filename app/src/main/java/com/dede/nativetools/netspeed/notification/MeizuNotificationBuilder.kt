package com.dede.nativetools.netspeed.notification

import android.app.Notification
import android.app.NotificationBuilderExt
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompatBuilderAccessor
import com.dede.nativetools.util.field
import com.dede.nativetools.util.getNotnull

/**
 * Meizu Notification Ext
 *
 * [Meizu Open Platform](http://open-wiki.flyme.cn/doc-wiki/index#id?76)
 *
 * package android.app;
 *
 * ``` java
 * class Notification$Builder {
 *
 *    public NotificationBuilderExt mFlymeNotificationBuilder;
 * }
 * ```
 *
 * ```
 * class NotificationBuilderExt {
 *
 *    setCircleProgressBar(boolean)
 *    setCircleProgressBarColor(int)
 *    setCircleProgressRimColor(int)
 *    setIconIntent(android.app.PendingIntent)
 *    setInternalApp(int)// 传1设置为内部app，显示状态栏通知图标
 *    setNotificationBitmapIcon(android.graphics.Bitmap)
 *    setNotificationIcon(int)
 *    setProgressBarDrawable(int)
 *    setRightIcon(int)
 *    setSimSlot(int)
 *    setSubTitle(java.lang.CharSequence)
 * }
 * ```
 */
class MeizuNotificationBuilder(private val builder: NotificationCompat.Builder) :
    NotificationExtension.Builder {

    override fun build(): Notification {
        val accessor = NotificationCompatBuilderAccessor(builder)
        try {
            Notification.Builder::class
                .java
                .field("mFlymeNotificationBuilder")
                .getNotnull<NotificationBuilderExt>(accessor.builder)
                .setInternalApp(1)
        } catch (e: Throwable) {}
        return accessor.build()
    }
}
