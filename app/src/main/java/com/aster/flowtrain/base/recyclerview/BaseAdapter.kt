package com.aster.flowtrain.base.recyclerview

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @author ichsanachmad
 */
abstract class BaseAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {
    private val items: MutableList<T> = mutableListOf()
    private val onItemClickListener: BaseViewHolder.OnItemClickListener? = null

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.apply {
            onBind(items[position])
            setOnClickListener(onItemClickListener)
        }
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(list: List<T>) {
        val diff = DiffUtil.calculateDiff(BaseDiffUtil(items, list))
        items.apply {
            clear()
            items.addAll(list)
        }
        diff.dispatchUpdatesTo(this)
    }

    fun removeAll() {
        val diff = DiffUtil.calculateDiff(BaseDiffUtil(items, listOf()))
        items.clear()
        diff.dispatchUpdatesTo(this)
    }

    fun getItem(position: Int): T {
        if (items.size > 0) return items[position]
        throw IndexOutOfBoundsException()
    }

    fun getItems(): List<T> = items
}