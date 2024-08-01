package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

object Graph {
    lateinit var database:WishDatabase

    val wishRepository by lazy {      //by lazy means that the variable wishRepository will only be initialised/loaded only when needed, the idea is to not
                                        // load everything at once at start of the application
        WishRepository(wishDao = database.wishDao())
    }


    //initialise the database
    //build the database named wishlist.db whenever the provide fun in called
    fun provide(context:Context){
        database= Room.databaseBuilder(context, WishDatabase::class.java,"wishlist.db").build()
    }


}