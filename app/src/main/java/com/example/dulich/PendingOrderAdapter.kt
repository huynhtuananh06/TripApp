package com.example.dulich

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PendingOrderAdapter(
    private val list: MutableList<AdminOrder>,
    private val onConfirm: (AdminOrder) -> Unit,
    private val onReject: (AdminOrder) -> Unit
) : RecyclerView.Adapter<PendingOrderAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val email = view.findViewById<TextView>(R.id.txtEmail)
        val hotel = view.findViewById<TextView>(R.id.txtHotel)
        val price = view.findViewById<TextView>(R.id.txtPrice)
        val checkIn = view.findViewById<TextView>(R.id.txtCheckIn)
        val btnConfirm = view.findViewById<Button>(R.id.btnConfirm)
        val btnReject = view.findViewById<Button>(R.id.btnReject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pending_order, parent, false)
        return VH(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {

        val item = list[position]

        holder.email.text = item.userEmail
        holder.hotel.text = item.hotelName
        holder.price.text = "Giá: ${item.price}"
        holder.checkIn.text = "Check-in: ${item.checkIn}"

        // 🎨 màu theo status
        when (item.status) {
            "confirmed" -> holder.itemView.setBackgroundColor(Color.parseColor("#D4F8D4"))
            "rejected" -> holder.itemView.setBackgroundColor(Color.parseColor("#FFD6D6"))
            else -> holder.itemView.setBackgroundColor(Color.WHITE)
        }

        // 🧠 disable nếu đã xử lý
        val isPending = item.status == "pending"
        holder.btnConfirm.isEnabled = isPending
        holder.btnReject.isEnabled = isPending

        // ✅ CHỈ GIỮ 1 CLICK LISTENER (QUAN TRỌNG)
        holder.btnConfirm.setOnClickListener {
            onConfirm(item)
        }

        holder.btnReject.setOnClickListener {
            onReject(item)
        }
    }
}