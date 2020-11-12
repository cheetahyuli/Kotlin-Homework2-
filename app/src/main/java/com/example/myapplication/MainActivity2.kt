package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var send_btn: Button
    private lateinit var set_drink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private var sugar = "無糖"
    private var ice_opt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener({
                _, i ->
            sugar = when (i) {
                R.id.radioButton1 -> "無糖"
                R.id.radioButton2 -> "少糖"
                R.id.radioButton3 -> "半糖"
                R.id.radioButton4 -> "全糖"
                else -> ""
            }
        })
        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener({
                _, i ->
            ice_opt = when (i) {
                R.id.radioButton5 -> "微冰"
                R.id.radioButton6 -> "少冰"
                R.id.radioButton7 -> "正常冰"
                else -> ""
            }
        })
        send_btn = findViewById(R.id.btn_send)
        send_btn.setOnClickListener{
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink.getText().toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar", sugar)
            b.putString("drink", drink)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }
    }
}