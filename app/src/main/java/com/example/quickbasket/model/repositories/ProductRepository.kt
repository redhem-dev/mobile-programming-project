package com.example.quickbasket.model.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.quickbasket.model.daos.ProductsDao
import com.example.quickbasket.model.models.Products
import com.example.quickbasket.model.models.toProduct
import kotlinx.coroutines.flow.flatMapConcat

class ProductRepository(private val productsDao: ProductsDao): BaseRepository<Products> {
    override suspend fun insert(t: Products) = productsDao.insert(t)

    override suspend fun update(t: Products) = productsDao.update(t)

    override suspend fun delete(t: Products) = productsDao.delete(t)

    override fun getOneStream(id: Int): Flow<Products?> = productsDao.getProduct(id)

    fun getAllProducts(): Flow<List<Products>> = productsDao.getAllProducts()

    fun getUserFavouriteProducts(userId: Int): Flow<List<Products>> {
        return productsDao.getUserFavouriteProducts(userId).flatMapConcat { favourites ->
            getAllProducts().map { products ->
                favourites.mapNotNull { favourite -> favourite.toProduct(products) }
            }
        }
    }
}