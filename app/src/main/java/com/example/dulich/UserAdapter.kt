package com.example.dulich

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val list: List<UserModel>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvEmail: TextView = v.findViewById(R.id.tvEmail)
        val tvCreated: TextView = v.findViewById(R.id.tvCreated)
        val tvLastLogin: TextView = v.findViewById(R.id.tvLastLogin)
        val sw: Switch = v.findViewById(R.id.switchStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(h: ViewHolder, position: Int) {

        val u = list[position]

        h.tvEmail.text = u.email
        h.tvCreated.text = "Created: ${u.createdAt}"
        h.tvLastLogin.text = "Last login: ${u.lastLogin}"
        h.sw.setOnCheckedChangeListener(null)

        h.sw.isChecked = !u.disabled

        h.sw.setOnCheckedChangeListener { _, isChecked ->

            val disabled = !isChecked

            updateStatus(

                h.itemView.context,

                u.uid,

                disabled

            )

            u.disabled = disabled

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    private fun updateStatus(

        context: Context,
        uid: String,
        disabled: Boolean

    ) {

        val url = "http://10.0.2.2:3000/users/$uid/status"

        val body = JSONObject()

        body.put("disabled", disabled)

        val request = JsonObjectRequest(

            Request.Method.PUT,

            url,

            body,

            {

                Toast.makeText(
                    context,
                    "Đã cập nhật",
                    Toast.LENGTH_SHORT
                ).show()

            },

            {

                Toast.makeText(
                    context,
                    "Lỗi cập nhật",
                    Toast.LENGTH_SHORT
                ).show()

            }

        )

        Volley.newRequestQueue(context).add(request)

    }
    }