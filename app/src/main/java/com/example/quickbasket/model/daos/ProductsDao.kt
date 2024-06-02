package com.example.quickbasket.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quickbasket.model.models.Favourites
import com.example.quickbasket.model.models.Products
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Products)

    @Update
    suspend fun update(product: Products)

    @Delete
    suspend fun delete(product: Products)

    @Query("SELECT * FROM Products WHERE id = :id")
    fun getProduct(id: Int): Flow<Products>

    @Query("SELECT * FROM Products")
    fun getAllProducts(): Flow<List<Products>>

    @Query("SELECT * FROM Favourites WHERE user_id = :userId")
    fun getUserFavouriteProducts(userId: Int): Flow<List<Favourites>>
}