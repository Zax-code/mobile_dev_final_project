package com.esilv.finalprojectzakariaabouliatim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DisneyViewerActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.disneyapi.dev/"

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disney_viewer)
        getDisneyCharacters()

        recyclerView = findViewById(R.id.DisneyCharacterRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showError(message: String) {
        // Handle and log errors
        // For now, we'll just log the error message
        // You may want to display an error message to the user
        println("Error: $message")
    }
    private fun getDisneyCharacters() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyAPI::class.java)

        api.getCharactersList().enqueue(object : Callback<DisneyResponse> {
            override fun onResponse(
                call: Call<DisneyResponse>,
                response: Response<DisneyResponse>
            ) {
                if (response.isSuccessful) {
                    val characters = response.body()?.data?.shuffled()
                    recyclerView.adapter = CharacterDataAdapter(characters!!)
                }
            }

            override fun onFailure(call: Call<DisneyResponse>, t: Throwable) {
            }

        })

    }
}
