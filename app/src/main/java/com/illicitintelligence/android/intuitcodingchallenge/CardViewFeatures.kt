package com.illicitintelligence.android.intuitcodingchallenge

import android.view.View

data class CardViewFeatures(
    val imageId: Int,
    val colorId: Int,
    val text: String,
    val isVisible: Boolean,
    val clickListener: View.OnClickListener? = null
)