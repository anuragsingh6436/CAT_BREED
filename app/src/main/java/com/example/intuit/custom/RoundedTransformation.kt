package com.example.intuit.custom

import android.graphics.*
import com.squareup.picasso.Transformation

class RoundedTransformation(private val radius: Int, private val margin: Int) : Transformation {


    override fun transform(source: Bitmap): Bitmap {
        val width = source.width
        val height = source.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        canvas.drawRoundRect(
            RectF(
                margin.toFloat(), margin.toFloat(),
                (width - margin).toFloat(), (height - margin).toFloat()
            ),
            radius.toFloat(), radius.toFloat(), paint
        )
        source.recycle()
        return bitmap
    }

    override fun key(): String {
        return "RoundedTransformation(radius=$radius, margin=$margin)"
    }
}