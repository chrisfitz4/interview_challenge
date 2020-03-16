package com.illicitintelligence.android.intuitcodingchallenge

import android.app.ActionBar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_cardview_layout.view.*


class CustomRVAdapter : RecyclerView.Adapter<CustomRVAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var listOfFeatures = ArrayList<CardViewFeatures>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listOfFeatures.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("TAG_X", "itemIsCustomCardView: ${holder.itemView is CustomCardview}")
        Log.d("TAG_X", "leftImageIsNull: ${(holder.itemView as CustomCardview).leftImageDrawable==null}")
        holder.itemView.setFeatures(listOfFeatures[position])
    }
}