package com.bayusurapati.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn_move_activity)

        btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity->{
                val IntentBiasa = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(IntentBiasa)
            }
        }
    }


    /*override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity ->{
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }*/
}