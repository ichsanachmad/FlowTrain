package com.aster.flowtrain.base.recyclerview

import androidx.recyclerview.widget.DiffUtil

/**
 * @author ichsanachmad
 */
abstract class BaseDiffUtil<T> : DiffUtil.Callback() {
    protected var oldItems: List<T> = listOf()
    protected var newItems: List<T> = listOf()

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        areContentsSame(oldItemPosition, newItemPosition)


    protected abstract fun areContentsSame(oldItemPosition: Int, newItemPosition: Int): Boolean
}