package com.example.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities=[Wish::class],
    version=1,
    exportSchema = false
)
abstract class WishDatabase: RoomDatabase(){
    abstract fun wishDao() : WishDao    //The return type of this method is WishDao. This means that when you call wishDao()
                                        // on an instance of WishDatabase, it returns an object that implements the WishDao
                                        //interface, which you can then use to interact with the wish-table in the database.
}