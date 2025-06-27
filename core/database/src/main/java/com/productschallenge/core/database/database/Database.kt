package com.productschallenge.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.productschallenge.core.database.data.converter.LocalDateTimeConverter
import com.productschallenge.core.database.data.dao.ProductEntityDao
import com.productschallenge.core.database.data.entity.product.ProductEntity

private const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    exportSchema = false,
    entities = [
        ProductEntity::class,
    ]
)
@TypeConverters(LocalDateTimeConverter::class)
internal abstract class Database : RoomDatabase() {
    abstract fun productEntityDao(): ProductEntityDao
}