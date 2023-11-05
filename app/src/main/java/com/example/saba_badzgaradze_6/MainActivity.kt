package com.example.saba_badzgaradze_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: PersonRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.reqResService.getPersons(1).enqueue(/* callback = */ object: Callback<Data<List<Person>>> {
            override fun onResponse(
                call: Call<Data<List<Person>>>,
                response: Response<Data<List<Person>>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    val adapter = PersonRecyclerAdapter(response.body()?.data!!)

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Data<List<Person>>>, t: Throwable) {

            }


        })


    }
}