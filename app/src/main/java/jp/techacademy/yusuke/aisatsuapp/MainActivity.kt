package jp.techacademy.yusuke.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ButtonをタッチするとTimePickerDialogを表示して，設定した時刻に応じてTextViewに表示されるあいさつを変化させてください。
//        2:00 ~ 9:59 では「おはよう」
//        10:00 ~ 17:59 では「こんにちは」
//        18:00 ~ 1:59 では「こんばんは」


        button.setOnClickListener {
            showTimePickerDialog()
        }

    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                when {
                    (2 <= hour && hour <= 9) -> textView.text = "おはよう"
                    (10 <= hour && hour <= 17) -> textView.text = "こんにちは"
                    else -> textView.text = "こんばんは"
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }


}
