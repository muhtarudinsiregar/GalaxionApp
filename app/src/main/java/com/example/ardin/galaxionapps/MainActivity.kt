package com.example.ardin.galaxionapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.ardin.galaxionapps.`interface`.RecyclerListener
import com.example.ardin.galaxionapps.data.model.Planetary
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerListener {
    override fun onClick(planetary: Planetary) {
        Toast.makeText(this, planetary.title, Toast.LENGTH_SHORT).show()
    }

    val nasa = ApiBuilder().call()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.layoutManager = LinearLayoutManager(this)
        getPlanetary()
    }

    private fun getPlanetary() {
        nasa.getPlanetary().enqueue(object : Callback<Planetary> {
            override fun onFailure(call: Call<Planetary>?, t: Throwable?) {
                errorMessage.text = t?.message
            }

            override fun onResponse(call: Call<Planetary>?, response: Response<Planetary>?) {
                response?.let {
                    if (it.isSuccessful) {
                        val body = it.body()
                        if (body != null) {
                            listView.adapter = PlanetaryAdapter(listOf(body, body), this@MainActivity)
                        }
                    }
                }
            }

        })
    }
}
