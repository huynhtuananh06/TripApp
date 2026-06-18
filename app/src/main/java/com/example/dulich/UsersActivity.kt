package com.example.dulich


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class UsersActivity : AppCompatActivity() {

    private val list = mutableListOf<UserModel>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UserAdapter(list)
        recyclerView.adapter = adapter

        loadUsers()
    }

    private fun loadUsers() {

        val url = "http://10.0.2.2:3000/users"
        val queue: RequestQueue = Volley.newRequestQueue(this)

        val request = JsonArrayRequest(
            url,
            { response ->

                list.clear()

                for (i in 0 until response.length()) {
                    val obj: JSONObject = response.getJSONObject(i)

                    list.add(
                        UserModel(
                            obj.getString("uid"),
                            obj.getString("email"),
                            obj.getString("createdAt"),
                            obj.getString("lastLogin"),
                            obj.getBoolean("disabled")
                        )
                    )
                }

                adapter.notifyDataSetChanged()
            },
            { error -> Log.e("USER", error.toString()) }
        )

        queue.add(request)
    }
}