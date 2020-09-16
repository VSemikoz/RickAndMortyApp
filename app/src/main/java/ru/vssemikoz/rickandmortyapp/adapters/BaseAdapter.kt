package ru.vssemikoz.rickandmortyapp.adapters

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(val context: Context) : RecyclerView.Adapter<BaseViewHolder<T>>() {
    var items: List<T>? = null
    var listener: OnRecyclerItemClickListener? = null


    open fun setOnItemClickListener(listener: OnRecyclerItemClickListener?) {
        this.listener = listener
    }

    interface OnRecyclerItemClickListener {
        fun onRecyclerItemClick(position: Int, imageView: ImageView)
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = items?.get(position)
        if (item != null) holder.onBind(item, listener)
    }

    override fun getItemCount(): Int = items?.size ?: 0
}
