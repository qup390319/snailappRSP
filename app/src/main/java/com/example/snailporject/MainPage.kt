package com.example.snailporject

import android.content.Context
import android.graphics.Color.rgb
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)


        val name = intent.getStringExtra("nameKey")
        textView3.text = "$name" + "出拳啦"

        var soundpool = SoundPool.Builder()
            .setMaxStreams(8)
            .build()

        var C = soundpool.load(this, R.raw.c, 1)


        btn_player.setOnClickListener {
            soundpool.play(C, 1.0f, 1.0f, 0, 0, 1.0f)

            val computer = (Math.random() * 3).toInt()
            tv_computer.text = "${if (computer == 0) "剪刀" else if (computer == 1) "石頭" else "布"}"

            when {
                rad_scissor.isChecked && computer == 2 || rad_stone.isChecked && computer == 0 || rad_paper.isChecked && computer == 1 -> {
                    tv_result.text = "恭喜你獲勝了"
                }
                rad_scissor.isChecked && computer == 1 || rad_stone.isChecked && computer == 2 || rad_paper.isChecked && computer == 0 -> {
                    tv_result.text = "你輸了 嗚嗚嗚"
                }
                else -> {
                    tv_result.text = "平手了"
                }
            }

            rad_gamer.setOnCheckedChangeListener { group, checkedId ->
                textView3.text = when (checkedId) {
                    R.id.rad_scissor -> "你選了剪刀"
                    R.id.rad_stone -> "你選了石頭"
                    R.id.rad_paper -> "你選了布"
                    else -> ""
                }
            }


        }
    }
}