package com.bayusurapati.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var btnIntentObject: Button
    private lateinit var btnIntentDial: Button
    private lateinit var btnIntentResult: Button
    private lateinit var tvHasil:TextView

    companion object{
        val REQUEST_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn_move_activity)
        btnIntentObject = findViewById(R.id.btn_move_with_object)
        val btnIntentData = findViewById<Button>(R.id.btn_move_with_data)
        btnIntentDial = findViewById(R.id.btn_dial_number)
        btnIntentResult = findViewById(R.id.btn_result)
        tvHasil = findViewById(R.id.tv_hasil)

        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentObject.setOnClickListener(this)
        btnIntentDial.setOnClickListener(this)
        btnIntentResult.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == HasilActivity.RESULT_CODE){
                val nilaiPilih = data?.getIntExtra(HasilActivity.EXTRA_PILIH, 0)
                tvHasil.text = "Nilai Hasil: $nilaiPilih"
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity->{
                val IntentBiasa = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(IntentBiasa)
            }
            R.id.btn_move_with_data -> run{
                val intentData = Intent(this@MainActivity ,MoveActivityData::class.java)
                intentData.putExtra(MoveActivityData.Extra_Text, "Halo nama Saya Nyoman Bayu Surapati sedang belajar Android")
                startActivity(intentData)
            }
            R.id.btn_move_with_object ->run {
                val nameObject = NameObject(
                    "Nyoman Bayu Surapati",
                    17,
                    "Jl.Danau Ranau 1 No G2B16",
                    "SMK Telkom Malang"
                )
                val IntenObject = Intent(this@MainActivity, MoveActivityObject::class.java)
                IntenObject.putExtra(MoveActivityObject.ExtraObject, nameObject)
                startActivity(IntenObject)
            }
            R.id.btn_dial_number ->run{
                val telp = "08199574655"
                val intentTelp = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telp"))
                startActivity(intentTelp)
            }
            R.id.btn_result ->run{
                val intentPindahResult = Intent(this@MainActivity, HasilActivity::class.java)
                startActivityForResult(intentPindahResult,REQUEST_CODE)
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