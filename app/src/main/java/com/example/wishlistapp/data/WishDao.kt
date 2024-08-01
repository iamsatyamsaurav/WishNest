package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)  //onConflict to handle what will happen when two wishes are same
    abstract suspend fun addAWish(wishEntity: Wish)  //this method does not need any implementation here

    //loads all wishes from wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>   //Using Flow as the return type allows for automatic real-time updates to your UI whenever
                                                    // the database content changes, without the need for manual refreshes. It provides an asynchronous,
                                                    //non-blocking way to observe data changes in a reactive manner
    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long): Flow<Wish>

}