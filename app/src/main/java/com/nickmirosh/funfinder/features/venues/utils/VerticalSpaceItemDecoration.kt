package com.nickmirosh.funfinder.features.venues.utils

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class VerticalSpaceItemDecoration(context: Context) : ItemDecoration() {
    private val VERTICAL_SPACE_HEIGHT_IN_DP = 8
    private val verticalSpaceHeightInPixels: Int
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeightInPixels
    }

    companion object {
        fun convertDpToPixel(dp: Float, context: Context): Float {
            return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }

    init {
        verticalSpaceHeightInPixels =
            Math.round(convertDpToPixel(VERTICAL_SPACE_HEIGHT_IN_DP.toFloat(), context))
    }
}