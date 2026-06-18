package com.example.dulich

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale
import com.google.firebase.firestore.FirebaseFirestore

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
        val quantity = view.findViewById<TextView>(R.id.txtQuantity)
        val btnPlus = view.findViewById<View>(R.id.btnPlus)
        val btnMinus = view.findViewById<View>(R.id.btnMinus)
        val btnDelete = view.findViewById<View>(R.id.btnDelete)
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

        val item = list[position]

        holder.name.text = item.hotelName

        holder.rating.text = "⭐ ${item.rating}"

        holder.quantity.text = item.quantity.toString()


        holder.price.text = formatVND(item.price * item.quantity)

        holder.btnPlus.setOnClickListener {
            val newQty = item.quantity + 1
            updateQuantity(item, newQty)
        }

        holder.btnMinus.setOnClickListener {
            if (item.quantity > 1) {
                val newQty = item.quantity - 1
                updateQuantity(item, newQty)
            }
        }

        holder.btnDelete.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Xóa vé")
                .setMessage("Bạn có chắc muốn xóa không?")
                .setPositiveButton("Xóa") { _, _ ->
                    deleteOrder(item)
                }
                .setNegativeButton("Hủy", null)
                .show()
        }

        when (item.status) {

            "confirmed" -> {
                holder.status.text = "🟢 Đã xác nhận"
                holder.status.setTextColor(Color.parseColor("#4CAF50"))
            }

            "cancelled" -> {
                holder.status.text = "🔴 Đã hủy"
                holder.status.setTextColor(Color.RED)
            }

            else -> {
                holder.status.text = "🟡 Đang chờ xác nhận"
                holder.status.setTextColor(Color.parseColor("#FF9800"))
            }
        }

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }
    private fun updateQuantity(order: Order, newQty: Double) {

        val db = FirebaseFirestore.getInstance()

        val newPrice = order.price * newQty

        db.collection("orders")
            .whereEqualTo("hotelName", order.hotelName)
            .get()
            .addOnSuccessListener { docs ->

                for (doc in docs) {
                    db.collection("orders")
                        .document(doc.id)
                        .update(
                            mapOf(
                                "quantity" to newQty,
                                "totalPrice" to newPrice
                            )
                        )
                }
            }
    }
    fun formatVND(amount: Double): String {
        val formatter = NumberFormat.getInstance(Locale("vi", "VN"))
        return "💰 " + formatter.format(amount) + " VND"
    }
    private fun deleteOrder(order: Order) {

        val db = FirebaseFirestore.getInstance()

        db.collection("orders")
            .whereEqualTo("hotelName", order.hotelName)
            .get()
            .addOnSuccessListener { docs ->

                for (doc in docs) {
                    db.collection("orders")
                        .document(doc.id)
                        .delete()
                }
            }
    }

}