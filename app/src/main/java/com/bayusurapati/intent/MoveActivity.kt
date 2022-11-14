package com.bayusurapati.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MoveActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntentKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        btnIntentKembali = findViewById(R.id.btn_kembali)

        btnIntentKembali.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_kembali -> {
                val IntentKembali = Intent(this@MoveActivity, MainActivity::class.java)
                startActivity(IntentKembali)
            }
        }
    }
}