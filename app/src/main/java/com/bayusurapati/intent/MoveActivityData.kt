package com.bayusurapati.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveActivityData : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val  Extra_Text = "ExTRA TEKS"
    }

    private lateinit var tvReciever : TextView
    private lateinit var btnIntentKembali: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        tvReciever = findViewById(R.id.tv_data_move)

        val textReceived = intent.getStringExtra(Extra_Text)
        val text = "Teks yang diterima : $textReceived"

        tvReciever.text = text

        btnIntentKembali = findViewById(R.id.btn_kembali)

        btnIntentKembali.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_kembali -> {
                val IntentKembali = Intent(this@MoveActivityData, MainActivity::class.java)
                startActivity(IntentKembali)
            }
        }
    }
}