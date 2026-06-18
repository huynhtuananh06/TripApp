package com.example.dulich

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
        h.sw.isChecked = !u.disabled

        h.sw.setOnCheckedChangeListener(null)
        h.sw.setOnCheckedChangeListener { _: CompoundButton, _: Boolean ->
            // UI trước
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    }