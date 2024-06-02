package com.example.quickbasket.model.repositories

import com.example.quickbasket.model.daos.UsersDao
import com.example.quickbasket.model.models.Users
import kotlinx.coroutines.flow.Flow

class UserRepository(private val usersDao: UsersDao): BaseRepository<Users> {
    override suspend fun insert(t: Users) = usersDao.insert(t)

    override suspend fun update(t: Users) = usersDao.update(t)

    override suspend fun delete(t: Users) = usersDao.delete(t)

    override fun getOneStream(id: Int): Flow<Users?> = usersDao.getUser(id)

    fun getEmail(email: String): Flow<Users> = usersDao.getEmail(email)

    fun login(password: String, username: String): Flow<Users?> = usersDao.login(password, username)

    fun getFavourites(id: Int) = usersDao.getFavourites(id)

}