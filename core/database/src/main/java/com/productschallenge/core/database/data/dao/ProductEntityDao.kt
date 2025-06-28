package com.productschallenge.core.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.productschallenge.core.database.data.entity.product.ProductEntity

@Dao
interface ProductEntityDao {

    @Query("DELETE FROM product")
    suspend fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<ProductEntity>)

    @Query("SELECT * FROM product")
    suspend fun getAll(): List<ProductEntity>
}
