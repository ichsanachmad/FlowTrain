package com.aster.flowtrain.base.recyclerview

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @author ichsanachmad
 */
abstract class BaseAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {
    private val items: MutableList<T> = mutableListOf()
    private var onItemClickListener: BaseViewHolder.OnItemClickListener? = null

    private fun differ(newItems: List<T>) = object : DiffUtil.Callback() {
        override fun getOldListSize(): Int = items.size

        override fun getNewListSize(): Int = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            items[oldItemPosition] == newItems[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            areContentsSame(oldItemPosition, newItems, newItemPosition)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.apply {
            onBind(items[position])
            setOnClickListener(onItemClickListener)
        }
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(itemClickListener: BaseViewHolder.OnItemClickListener) {
        this.onItemClickListener = itemClickListener
    }

    fun updateItems(list: List<T>) {
        val diff = DiffUtil.calculateDiff(differ(list))
        items.apply {
            clear()
            items.addAll(list)
        }
        diff.dispatchUpdatesTo(this)
    }

    fun removeAll() {
        val diff = DiffUtil.calculateDiff(differ(listOf()))
        items.clear()
        diff.dispatchUpdatesTo(this)
    }

    fun getItem(position: Int): T {
        if (items.size > 0) return items[position]
        throw IndexOutOfBoundsException()
    }

    fun getItems(): List<T> = items

    protected abstract fun areContentsSame(
        oldItemPosition: Int,
        newItems: List<T>,
        newItemPosition: Int
    ): Boolean
}