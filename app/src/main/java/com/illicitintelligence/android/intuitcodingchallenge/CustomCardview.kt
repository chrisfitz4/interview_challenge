package com.illicitintelligence.android.intuitcodingchallenge

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.custom_cardview_layout.view.*

class CustomCardview(context: Context, attrs: AttributeSet?)
    : FrameLayout(context, attrs){

    init{
        LayoutInflater.from(context).inflate(R.layout.custom_cardview_layout, this, true)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomCardview, 0, 0)
        Log.d("TAG_X", "$attributes")
        val foregroundColor = attributes.getColor(R.styleable.CustomCardview_selectedForegroundColor, Color.GRAY)
        val inputText = attributes.getText(R.styleable.CustomCardview_selectedInputText)
        val imageReference = attributes.getResourceId(R.styleable.CustomCardview_leftImageDrawableSource, 0)
        leftImageDrawable.apply{
            setImageResource(imageReference)
            setColorFilter(foregroundColor)
        }
        infoTextView.apply{
            setTextColor(foregroundColor)
            text = inputText
        }
    }

    fun setFeatures(features: CardViewFeatures){
        leftImageDrawable.setImageResource(features.imageId)
        leftImageDrawable.setColorFilter(ContextCompat.getColor(context, features.colorId))
        infoTextView.text = features.text
        infoTextView.setTextColor(ContextCompat.getColor(context, features.colorId))
        chevron.visibility = if(features.isVisible){
            View.VISIBLE
        }else{
            View.GONE
        }
        features.clickListener?.let{
            chevron.setOnClickListener(it)
        }
    }

}