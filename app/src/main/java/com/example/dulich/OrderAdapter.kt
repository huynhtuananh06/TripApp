package com.example.dulich

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import java.text.NumberFormat
import java.util.Locale

class OrderAdapter(
    private val list: List<Order>,
    private val onClick: (Order) -> Unit
) : RecyclerView.Adapter<OrderAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.txtName)
        val price = view.findViewById<TextView>(R.id.txtPrice)
        val rating = view.findViewById<TextView>(R.id.txtRating)

        val txtCheckIn = view.findViewById<TextView>(R.id.txtCheckIn)
        val txtQuantity = view.findViewById<TextView>(R.id.txtQuantity)
        val txtStatus = view.findViewById<TextView>(R.id.txtStatus)

        val btnPlus = view.findViewById<View>(R.id.btnPlus)
        val btnMinus = view.findViewById<View>(R.id.btnMinus)
        val btnDelete = view.findViewById<View>(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return VH(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {

        val item = list[position]

        holder.name.text = item.hotelName
        holder.rating.text = "⭐ ${item.rating}"
        holder.txtCheckIn.text = "Check-in: ${item.checkIn}"
        holder.txtQuantity.text = item.quantity.toString()
        holder.price.text = formatVND(item.price * item.quantity)

        // ================= STATUS (FIXED) =================
        holder.txtStatus.text = when (item.status) {
            "paid" -> "💰 Đã thanh toán"
            "pending" -> "⏳ Chờ thanh toán"
            else -> "⏳ Chờ thanh toán"
        }

        holder.txtStatus.setTextColor(
            when (item.status) {
                "paid" -> Color.parseColor("#4CAF50")
                else -> Color.parseColor("#FF9800")
            }
        )

        // ================= BACKGROUND =================
        holder.itemView.setBackgroundColor(
            when (item.status) {
                "paid" -> Color.parseColor("#D4F8D4")
                else -> Color.WHITE
            }
        )

        // ================= PLUS =================
        holder.btnPlus.setOnClickListener {
            updateQuantity(item, item.quantity + 1)
        }

        // ================= MINUS =================
        holder.btnMinus.setOnClickListener {
            if (item.quantity > 1) {
                updateQuantity(item, item.quantity - 1)
            }
        }

        // ================= DELETE =================
        holder.btnDelete.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Xóa đơn")
                .setMessage("Bạn chắc chắn muốn xóa?")
                .setPositiveButton("Xóa") { _, _ ->
                    deleteOrder(item)
                }
                .setNegativeButton("Hủy", null)
                .show()
        }

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    // ================= UPDATE QUANTITY (FIXED orderId) =================
    private fun updateQuantity(order: Order, newQty: Double) {

        val db = FirebaseFirestore.getInstance()
        val newPrice = order.price * newQty

        db.collection("orders")
            .document(order.orderId)
            .update(
                mapOf(
                    "quantity" to newQty,
                    "totalPrice" to newPrice
                )
            )
    }

    // ================= FORMAT MONEY =================
    private fun formatVND(amount: Double): String {
        val formatter = NumberFormat.getInstance(Locale("vi", "VN"))
        return "💰 ${formatter.format(amount)} VND"
    }

    // ================= DELETE (FIXED orderId) =================
    private fun deleteOrder(order: Order) {

        FirebaseFirestore.getInstance()
            .collection("orders")
            .document(order.orderId)
            .delete()
    }
}