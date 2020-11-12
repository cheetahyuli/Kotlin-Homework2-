package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.Nullable
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tv_meal : TextView
    private lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn_choice)
        tv_meal = findViewById(R.id.tv_meal)
        btn.setOnClickListener{
            startActivityForResult(
                Intent(this@MainActivity,
                    MainActivity2::class.java),1)
        }
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data==null)return
        if (requestCode == 1) {
            var str1 = data?.getStringExtra("drink")
            var str2 = data?.getStringExtra("sugar")
            var str3 = data?.getStringExtra("ice")
            tv_meal.setText(String.format("飲料：%s\n\n甜度：%s\n\n冰塊：%s\n\n",
                str1, str2, str3))
        }
    }
}
