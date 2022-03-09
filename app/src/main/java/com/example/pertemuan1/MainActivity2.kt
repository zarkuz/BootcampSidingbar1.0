package com.example.pertemuan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tv_nama: TextView = findViewById(R.id.tvMain2_Nama)
        val tv_nomor: TextView = findViewById(R.id.tvMain2_Nomor)
//        var tvgetData_Nomor: String = intent.getStringExtra("txtnomor").toString()
//        tv_nama.setText(intent.getStringExtra("txtnama"))
//        tv_nomor.setText(tvgetData_Nomor)
        val bundle = intent.extras
        tv_nama.setText(bundle?.getString("txtnama"))
        tv_nomor.setText(bundle?.getString("txtnomor"))
    }
}