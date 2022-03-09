package com.example.pertemuan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var btn_submit: Button
    lateinit var btn_update: Button
    lateinit var btn_delete: Button
    lateinit var btn_view: Button
    lateinit var edit_nama: EditText
    lateinit var edit_nomorhp: EditText
    lateinit var edit_id: EditText
    lateinit var apiService: ServiceInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        declaration()
        myfunction()

    }
    fun myfunction(){

        btn_view.setOnClickListener{
            startActivity(Intent(this, MainActivity3::class.java))
        }
        btn_submit.setOnClickListener{
            val array = DataClassItem()
            array.id = edit_id.text.toString().toInt()
            array.nama = edit_nama.text.toString()
            array.nomor = edit_nomorhp.text.toString()
            apiService.postKontak(array).enqueue(object : Callback<DataClassItem>{
                override fun onResponse(
                    call: Call<DataClassItem>,
                    response: Response<DataClassItem>
                ) {
                    Toast.makeText(baseContext, "Data Berhasil di Tambahkan", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<DataClassItem>, t: Throwable) {
                    Toast.makeText(baseContext, "Data Gagal di Tambahkan", Toast.LENGTH_SHORT).show()
                }
            })
            edit_id.setText("")
            edit_nama.setText("")
            edit_nomorhp.setText("")
        }
        btn_update.setOnClickListener {
            apiService.updateKontak(edit_id.text.toString().toInt(), edit_nama.text.toString(), edit_nomorhp.text.toString())
                .enqueue(object : Callback<DataClassItem>{
                    override fun onResponse(
                        call: Call<DataClassItem>,
                        response: Response<DataClassItem>
                    ) {
                        Toast.makeText(baseContext, "Data Berhasil di Perbarui", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<DataClassItem>, t: Throwable) {
                        Toast.makeText(baseContext, "Data Gagal di Perbarui", Toast.LENGTH_SHORT).show()
                    }
                })
            edit_id.setText("")
            edit_nama.setText("")
            edit_nomorhp.setText("")
        }

        btn_delete.setOnClickListener {
            apiService.deletekontak(edit_id.text.toString().toInt())
                .enqueue(object : Callback<DataClassItem>{
                    override fun onResponse(
                        call: Call<DataClassItem>,
                        response: Response<DataClassItem>
                    ) {
                        Toast.makeText(baseContext, "Data Berhasil di Hapus", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<DataClassItem>, t: Throwable) {
                        Toast.makeText(baseContext, "Data Gagal di Hapus", Toast.LENGTH_SHORT).show()
                    }
                })
            edit_id.setText("")
            edit_nama.setText("")
            edit_nomorhp.setText("")
        }
    }
    fun declaration(){
        btn_submit = findViewById(R.id.btnMain_Submit)
        btn_update = findViewById(R.id.btnMain_Update)
        btn_delete = findViewById(R.id.btnMain_Delete)
        btn_view = findViewById(R.id.btnMain_View)
        edit_id = findViewById(R.id.editMain_Id)
        edit_nama = findViewById(R.id.editMain_Nama)
        edit_nomorhp = findViewById(R.id.editMain_Nomorhp)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
    }
}