package com.example.dulich

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TripAdapter(
    private val list: List<TripItem>,
    private val onBook: (TripItem.TourItem) -> Unit,
    private val onDetail: (TripItem.TourItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_TOUR = 1

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is TripItem.Header -> TYPE_HEADER
            is TripItem.TourItem -> TYPE_TOUR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_section, parent, false)

            HeaderVH(view)

        } else {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tour, parent, false)

            TourVH(view)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = list[position]

        when (holder) {

            is HeaderVH -> {
                holder.bind(item as TripItem.Header)
            }

            is TourVH -> {
                holder.bind(
                    item as TripItem.TourItem,
                    onBook,
                    onDetail
                )
            }
        }
    }

    // HEADER VIEW
    class HeaderVH(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<TextView>(R.id.txtSection)

        fun bind(item: TripItem.Header) {
            title.text = item.title
        }
    }

    // TOUR VIEW
    class TourVH(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.txtName)
        private val rating = view.findViewById<TextView>(R.id.txtRating)
        private val price = view.findViewById<TextView>(R.id.txtPrice)
        private val img = view.findViewById<ImageView>(R.id.imgTour)

        private val btnBook = view.findViewById<Button>(R.id.btnBook)
        private val btnDetail = view.findViewById<Button>(R.id.btnDetail)

        fun bind(
            item: TripItem.TourItem,
            onBook: (TripItem.TourItem) -> Unit,
            onDetail: (TripItem.TourItem) -> Unit
        ) {

            name.text = item.name
            rating.text = "⭐ ${item.rating}"
            price.text = item.price
            img.setImageResource(item.image)

            btnBook.setOnClickListener {
                onBook(item)
            }

            btnDetail.setOnClickListener {
                onDetail(item)
            }
        }
    }
}