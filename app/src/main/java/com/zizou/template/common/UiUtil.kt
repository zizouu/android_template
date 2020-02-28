package com.zizou.template.common

import android.util.TypedValue
import com.zizou.template.TemplateApplication
import kotlin.math.ceil

class UiUtil {
    companion object {
        fun dpToPx(dp: Float) =
            ceil(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, TemplateApplication.application.resources.displayMetrics
            ).toDouble()).toInt()
    }
}