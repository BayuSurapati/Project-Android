package com.bayusurapati.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.jar.Attributes.Name

class MoveActivityObject : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvReceived: TextView

    companion object{
        const val ExtraObject = "ExtraObject"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        tvReceived = findViewById(R.id.tv_data_move_object)

        val nameObject = intent.getParcelableExtra<NameObject>(ExtraObject) as NameObject
        val text = "Nama: ${nameObject.nama.toString()}\nUmur: ${nameObject.umur.toString()}\nAlamat: ${nameObject.alamat.toString()}\nSekolah: ${nameObject.sekolah.toString()}"

        tvReceived.text = text

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}