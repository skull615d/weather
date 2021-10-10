package com.afanasyeva656.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val textView = findViewById<TextView>(R.id.textView)
//        textView.text = presenter.getTemperature()
//
//        val list = listOf<Int>(1, 2, 3, 4)
//        val filteredList: List<Int>? = null
//        Log.d("test_list", "$filteredList")
//
//        filteredList?.let { textView.text = it.toString() }
//        filteredList?.let { list -> textView.text = list.toString() }

    }
}