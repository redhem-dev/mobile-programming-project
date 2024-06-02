package com.example.quickbasket.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import com.example.quickbasket.model.models.Favourites

import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favourite: Favourites)

    @Update
    suspend fun update(favourite: Favourites)

    @Delete
    suspend fun delete(favourite: Favourites)

    @Query("SELECT * FROM Favourites WHERE product_id = :productId")
    suspend fun getFavourite(productId: Int): Favourites?

    @Query("SELECT * FROM Favourites WHERE user_id = :userId")
    suspend fun getFavourites(userId: Int): List<Favourites> {
        return getFavourites(userId)
    }

    @Query("DELETE FROM Favourites WHERE user_id = :userId AND product_id = :productId")
    suspend fun deleteByUserIdAndProductId(userId: Int, productId: Int)
}