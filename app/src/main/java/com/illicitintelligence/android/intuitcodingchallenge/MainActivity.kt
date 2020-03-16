package com.illicitintelligence.android.intuitcodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_cardview_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener1: View.OnClickListener = View.OnClickListener {
            Toast.makeText(this@MainActivity, getString(R.string.testOneText), Toast.LENGTH_LONG)
                .show()
        }
        val listener2: View.OnClickListener = View.OnClickListener {
            Toast.makeText(this@MainActivity, "test 2 working", Toast.LENGTH_LONG).show()
        }

        customCardView.chevron.setOnClickListener(listener1)

        val feature = CardViewFeatures(
            R.drawable.ic_color_lens,
            R.color.testColor1,
            "I hope this works!",
            true,
            listener1
        )
        val features2 = CardViewFeatures(
            R.drawable.ic_chevron,
            R.color.testColor2,
            "test 2",
            false,
            listener2
        )
        val listOfFeatures = ArrayList<CardViewFeatures>().apply {
            addAll(listOf(feature, features2, feature, features2, features2, feature))
        }
        val myAdapter = CustomRVAdapter()
        myAdapter.listOfFeatures = listOfFeatures
        myRecyclerView.adapter = myAdapter
    }
}
