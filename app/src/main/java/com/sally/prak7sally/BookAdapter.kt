package com.sally.prak7sally

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookAdapter(
    private val list: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txtTitle: TextView = v.findViewById(R.id.txtTitle)
        val txtDate: TextView = v.findViewById(R.id.txtDate)
        val imgBook: ImageView = v.findViewById(R.id.imgBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = list[position]

        holder.txtTitle.text = book.title
        holder.txtDate.text = book.releaseDate ?: ""

        Glide.with(holder.itemView.context)
            .load(book.cover ?: "")
            .into(holder.imgBook)

        holder.itemView.setOnClickListener {
            onClick(book)
        }
    }

    override fun getItemCount(): Int = list.size
}
