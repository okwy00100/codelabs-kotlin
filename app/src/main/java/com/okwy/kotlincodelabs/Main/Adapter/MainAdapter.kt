package com.okwy.kotlincodelabs.Main.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.okwy.kotlincodelabs.R


class MainAdapter(
    private val context: Context,
    private val conceptList: List<String>?,
    private val listItemClickListener: ListItemClickListener
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface ListItemClickListener {
        fun onListItemClick(menuItem: String?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(conceptList!![position], listItemClickListener)
    }

    override fun getItemCount(): Int {
        return conceptList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        var menuItem: TextView
        var menuItem: TextView = itemView.findViewById(R.id.menuItem)
        fun bind(item: String?, listItemClickListener: ListItemClickListener) {
            menuItem.text = item
            itemView.setOnClickListener {
                listItemClickListener.onListItemClick(item, this@ViewHolder.adapterPosition)
            }
        }

        //        init {
//            menuItem = itemView.findViewById(R.id.menuItem)
//        }
    }
}
