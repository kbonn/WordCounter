package com.bonndev.wordcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.TextView

class MapWordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_words)

        val textString = intent.getStringExtra(EXTRA_MESSAGE)
        Log.d("DEBUG","Test")
        val textMap = convertStringToMap(textString)

        val textView = findViewById<TextView>(R.id.textView).apply {
//            text = convertStringToMap(textString).toString()
            text = printAsStrings(textMap)
        }
    }

    private fun convertStringToMap(textString: String?): Map<String, Int> {
        val textMap = mutableMapOf<String, Int>()
        val splitText = textString?.split(" ")
        for (i in splitText!!) {
            if (!textMap.containsKey(i)) {
                textMap[i] = 1
            } else {
                textMap[i] = textMap.getValue(i) + 1
            }
        }
        val sortedText = textMap.toList().sortedBy { (_, value) -> value }.toMap().toSortedMap(reverseOrder())
        Log.d("DEBUG","The text is: $sortedText")
        return sortedText
    }

    private fun printAsStrings(mapObject: Map<String, Int>): String {
        var outputText = ""
        for ((k, v) in mapObject) {
            outputText = outputText.plus("$k = $v").plus("\n")
        }
        Log.d("DEBUG", "Output text is: $outputText")
        return outputText
    }

}