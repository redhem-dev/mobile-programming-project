package com.example.quickbasket.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.quickbasket.model.daos.UsersDao
import com.example.quickbasket.model.daos.ProductsDao
import com.example.quickbasket.model.daos.FavouritesDao
import com.example.quickbasket.model.models.Users
import com.example.quickbasket.model.models.Products
import com.example.quickbasket.model.models.Favourites


@Database(entities = [Users::class, Products::class, Favourites::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UsersDao
    abstract fun productDao(): ProductsDao
    abstract fun favouriteDao(): FavouritesDao

    companion object{
        @Volatile
        private var Instance: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, UserDatabase::class.java, "UserAPPDatabase")
                    .build().also { Instance = it }
            }
        }

    }
}