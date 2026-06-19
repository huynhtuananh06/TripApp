package com.example.dulich

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PlaceAdapter(
    private var list: List<Place>
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        val image =
            itemView.findViewById<ImageView>(
                R.id.imgPlace
            )

        val name =
            itemView.findViewById<TextView>(
                R.id.txtName
            )

        val location =
            itemView.findViewById<TextView>(
                R.id.txtLocation
            )
        val btnMore = itemView.findViewById<Button>(R.id.btnMore)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_place, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val place = list[position]

        holder.image.setImageResource(place.image)
        holder.name.text = place.name
        holder.location.text = place.location

        holder.btnMore.setOnClickListener {

            val intent = Intent(holder.itemView.context, SuggestActivity::class.java)

            intent.putExtra("placeName", place.name)

            holder.itemView.context.startActivity(intent)
        }
        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                SuggestActivity::class.java
            )

            intent.putExtra("placeName", place.name)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateList(
        newList: List<Place>
    ){

        list = newList

        notifyDataSetChanged()

    }

}