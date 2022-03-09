package com.example.pertemuan1

import java.util.ArrayList

object DataItem {
    private val namaData = arrayOf(
        "Budi",
        "David",
        "Agus"
    )
    private val nomorData = arrayOf(
        "0857xx",
        "0899xx",
        "0888xx"
    )

    val listData: ArrayList<DataClassItem>
        get() {
            val listItem = arrayListOf<DataClassItem>()
            for (position in namaData.indices){
                val dataItem = DataClassItem()
                dataItem.nama = namaData[position]
                dataItem.nomor = nomorData[position]
                listItem.add(dataItem)
            }
            return listItem
        }
}