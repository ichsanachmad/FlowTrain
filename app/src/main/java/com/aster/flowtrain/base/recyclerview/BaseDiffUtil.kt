package com.aster.flowtrain.base.recyclerview

import androidx.recyclerview.widget.DiffUtil

/**
 * @author ichsanachmad
 */
class BaseDiffUtil<T>(private val oldItems: List<T>, private val newItems: List<T>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].hashCode() == newItems[newItemPosition].hashCode()
}