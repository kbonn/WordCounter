package com.bonndev.wordcounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submitText(view: View) {
        val enteredText = findViewById<EditText>(R.id.text_box)
        val textString = enteredText.text.toString()
        val intent = Intent(this, MapWordsActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, textString)
        }
        startActivity(intent)
    }
}