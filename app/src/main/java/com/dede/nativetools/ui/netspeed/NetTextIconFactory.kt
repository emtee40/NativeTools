package com.dede.nativetools.ui.netspeed

import android.graphics.*
import kotlin.math.abs


/**
 * Created by hsh on 2017/5/11 011 下午 05:17.
 * 通知栏网速图标工厂
 */
object NetTextIconFactory {

    private const val WIDTH = 100
    private const val HEIGHT = 100

    /**
     * 创建下载图标
     *
     * @param text1 下载速度
     * @param text2 单位
     * @return bitmap
     */
    fun createSingleIcon(text1: String, text2: String, scale: Float = 1f): Bitmap {
        val bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.isAntiAlias = true
        paint.textSize = 51f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.textAlign = Paint.Align.CENTER
        paint.color = Color.WHITE
        var fontMetrics = paint.fontMetrics
        val textY = abs(fontMetrics.top) - fontMetrics.descent
        val canvas = Canvas(bitmap)
        canvas.scale(scale, scale, 50f, 50f)
        canvas.drawText(text1, 50f, textY + 6, paint)
        paint.textSize = 39f
        fontMetrics = paint.fontMetrics
        val text2Y = abs(fontMetrics.top) - fontMetrics.descent
        canvas.drawText(text2, 50f, textY + text2Y + 15f, paint)
        return bitmap
    }

    /**
     * 创建上传下载的图标
     *
     * @param text1 上行网速
     * @param text2 下行网速
     * @return bitmap
     */
    fun createDoubleIcon(text1: String, text2: String, scale: Float = 1f): Bitmap {
        val bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.isAntiAlias = true
        paint.textSize = 42f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.textAlign = Paint.Align.CENTER
        paint.color = Color.WHITE
        var fontMetrics = paint.fontMetrics
        val textY = abs(fontMetrics.top) - fontMetrics.descent
        val canvas = Canvas(bitmap)
        canvas.scale(scale, scale, 50f, 50f)
        canvas.drawText(text1, 50f, textY + 5, paint)
        paint.textSize = 42f
        fontMetrics = paint.fontMetrics
        val text2Y = abs(fontMetrics.top) - fontMetrics.descent
        canvas.drawText(text2, 50f, textY + text2Y + 21f, paint)
        return bitmap
    }
}
