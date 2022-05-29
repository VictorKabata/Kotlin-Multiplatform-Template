package com.vickikbt.kmptemplate.android.ui.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.vickikbt.kmptemplate.android.R
import com.vickikbt.kmptemplate.presentation.utils.Greeting
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val greeting: Greeting by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greeting.greet()
    }
}
