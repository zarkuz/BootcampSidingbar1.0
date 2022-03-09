package com.example.pertemuan1

import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("Kontak")
    fun getData(): Call<List<DataClassItem>>
    @POST("Kontak")
    fun postKontak(@Body dataClassItem: DataClassItem): Call<DataClassItem>
    @FormUrlEncoded
    @HTTP(method="PUT", path = "Kontak", hasBody = true)
    fun updateKontak(
        @Field("id") id:Int,
        @Field("nama") nama:String,
        @Field("nomor") nomor:String): Call<DataClassItem>
    @FormUrlEncoded
    @HTTP(method="DELETE", path = "Kontak", hasBody = true)
    fun deletekontak(
        @Field("id") id:Int): Call<DataClassItem>

}