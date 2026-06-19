package com.example.dulich

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class ManageHotelAdapter(
    private val hotels: List<Hotel>
) : RecyclerView.Adapter<ManageHotelAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.imgHotel)
        val name = view.findViewById<TextView>(R.id.txtName)
        val address = view.findViewById<TextView>(R.id.txtAddress)
        val price = view.findViewById<TextView>(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotel_manage, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = hotels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val hotel = hotels[position]

        holder.image.setImageResource(hotel.image)
        holder.name.text = hotel.name
        holder.address.text = hotel.address

        holder.price.text =
            NumberFormat.getCurrencyInstance(Locale("vi","VN"))
                .format(hotel.price)
    }
}