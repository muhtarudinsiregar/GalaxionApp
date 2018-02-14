package com.example.ardin.galaxionapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.ardin.galaxionapps.data.model.Planetary
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val nasa = ApiBuilder().call()
    var planetary: Planetary? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        getPlanetary()
    }

    fun getPlanetary() {
        nasa.getPlanetary().enqueue(object : Callback<Planetary> {
            override fun onFailure(call: Call<Planetary>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Planetary>?, response: Response<Planetary>?) {
                if (response?.isSuccessful!!) {
                    list.adapter = ListAdapter(this@MainActivity, response.body()!!)
                }
            }

        })
    }
}
