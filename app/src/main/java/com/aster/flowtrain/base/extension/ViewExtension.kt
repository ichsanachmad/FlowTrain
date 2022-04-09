package com.aster.flowtrain.base.extension

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup

/**
 * @author ichsanachmad
 */

fun View.setMargins(start: Int?, end: Int?, top: Int?, bottom: Int?) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(
        start ?: params.leftMargin,
        top ?: params.topMargin,
        end ?: params.rightMargin,
        bottom ?: params.bottomMargin
    )
    layoutParams = params
}

fun dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)
        .toInt()