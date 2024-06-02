package com.example.quickbasket.model.repositories

import com.example.quickbasket.model.daos.FavouritesDao
import com.example.quickbasket.model.models.Favourites
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavouriteRepository(private val favouritesDao: FavouritesDao): BaseRepository<Favourites> {
    override suspend fun insert(t: Favourites) = favouritesDao.insert(t)

    override suspend fun update(t: Favourites) = favouritesDao.update(t)

    override suspend fun delete(t: Favourites) = favouritesDao.delete(t)

    override fun getOneStream(id: Int): Flow<Favourites?> = flow {
        emit(favouritesDao.getFavourite(id))
    }

    suspend fun getFavourites(id: Int) = favouritesDao.getFavourites(id)

    suspend fun deleteByUserIdAndProductId(userId: Int, tourId: Int) {
        favouritesDao.deleteByUserIdAndProductId(userId, tourId)
    }
}