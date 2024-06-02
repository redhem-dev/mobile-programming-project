package com.example.quickbasket

import android.app.Application
import com.example.quickbasket.model.AppContainer
import com.example.quickbasket.model.AppDataContainer


class UserApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
