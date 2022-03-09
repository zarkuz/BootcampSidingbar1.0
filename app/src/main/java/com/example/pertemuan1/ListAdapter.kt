package com.example.pertemuan1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listDataItem: ArrayList<DataClassItem>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tv_nama: TextView = itemView.findViewById(R.id.tvMain3cv_Nama)
        var tv_nomor: TextView = itemView.findViewById(R.id.tvMain3cv_Nomor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.list_data_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataItem.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val itemData = listDataItem[position]
        holder.tv_nama.text = itemData.nama
        holder.tv_nomor.text = itemData.nomor
    }
}