package com.example.pertemuan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.ArrayList

class MainActivity3 : AppCompatActivity() {
    private lateinit var rvDataItem: RecyclerView
    lateinit var apiService: ServiceInterface
    private var list: ArrayList<DataClassItem> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        rvDataItem = findViewById(R.id.rvMain3_data)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getData().enqueue(object : Callback<List<DataClassItem>>{
            override fun onResponse(
                call: Call<List<DataClassItem>>,
                response: Response<List<DataClassItem>>
            ) {
                if(response.isSuccessful){
                    val res = response.body()
                    list.addAll(res!!)
                    rvDataItem.layoutManager = LinearLayoutManager(this@MainActivity3)
                    rvDataItem.adapter = ListAdapter(list)
                }
            }

            override fun onFailure(call: Call<List<DataClassItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
//        list.addAll(DataItem.listData)
//        showRecyclerView()

    }
//    private fun showRecyclerView(){
//        rvDataItem.layoutManager = LinearLayoutManager(this)
//        val listAdapter = ListAdapter(list)
//        rvDataItem.adapter = listAdapter
//    }
}