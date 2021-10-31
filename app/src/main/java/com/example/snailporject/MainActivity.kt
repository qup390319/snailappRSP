package com.example.snailporject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_page.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{
            val intent = Intent(this, MainPage::class.java)
            val name = editName.text.toString()   //將ed_name文字轉成String字串
            intent.putExtra("nameKey", name)     //putExtra("Key", value)
            startActivity(intent)
            }
        }

    }