package com.example.wishlistapp

import android.app.Application

class WishListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)  //the context(location) is this wishlist application where the database is needed to be created
    }
}