package com.example.dulich

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(
    private val list: List<Order>,
    private val onClick: (Order) -> Unit
) : RecyclerView.Adapter<OrderAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {

        val name =
            view.findViewById<TextView>(
                R.id.txtName
            )

        val price =
            view.findViewById<TextView>(
                R.id.txtPrice
            )

        val rating =
            view.findViewById<TextView>(
                R.id.txtRating
            )

        val status =
            view.findViewById<TextView>(
                R.id.txtStatus
            )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VH {

        val v =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_order,
                    parent,
                    false
                )

        return VH(v)
    }

    override fun getItemCount() =
        list.size

    override fun onBindViewHolder(
        holder: VH,
        position: Int
    ) {

        val item =
            list[position]

        holder.name.text =
            item.hotelName

        holder.price.text =
            item.price

        holder.rating.text =
            "⭐ ${item.rating}"

        when(item.status){

            "confirmed" -> {

                holder.status.text =
                    "🟢 Đã xác nhận"

                holder.status.setTextColor(
                    Color.parseColor("#4CAF50")
                )
            }

            "cancelled" -> {

                holder.status.text =
                    "🔴 Đã hủy"

                holder.status.setTextColor(
                    Color.RED
                )
            }

            else -> {

                holder.status.text =
                    "🟡 Đang chờ xác nhận"

                holder.status.setTextColor(
                    Color.parseColor("#FF9800")
                )
            }
        }

        holder.itemView.setOnClickListener {

            onClick(item)

        }
    }
}