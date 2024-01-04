package com.esilv.finalprojectzakariaabouliatim
import retrofit2.http.GET
import retrofit2.Call

interface DisneyAPI {
    @GET("character")
    fun getCharactersList(): Call<DisneyResponse>
}
