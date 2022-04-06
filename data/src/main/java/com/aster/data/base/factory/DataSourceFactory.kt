package com.aster.data.base.factory

import com.aster.data.base.source.DataSource

/**
 * @author ichsanachmad
 */
interface DataSourceFactory<out T> {
    fun generateDataSource(@DataSource dataSource: String): T
}