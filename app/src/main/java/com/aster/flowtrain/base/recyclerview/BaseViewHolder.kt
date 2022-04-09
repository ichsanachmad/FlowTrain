package com.aster.flowtrain.base.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author ichsanachmad
 */
abstract class BaseViewHolder<T>(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root) {
    open fun onBind(data: T) {}

    fun setOnClickListener(listener: OnItemClickListener?) {
        itemView.setOnClickListener { listener?.onClick(adapterPosition) }
    }

    fun interface OnItemClickListener {
        fun onClick(position: Int)
    }
}