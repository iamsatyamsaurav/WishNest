package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true) //autoGenerate =true, whenever a new wish is created ,it will automatically increment the value of id by 1
    val id: Long=0L,
    @ColumnInfo(name = "wish-title")
    val title: String="",
    @ColumnInfo(name = "wish-desc")
    val description : String=""
)

object dummyWish{
    val wishList=listOf(
        Wish(title="Google watch",description="I want it on my birthday"),
        Wish(title="Mouse",description="I want a protonics wired mouse for development"),
        Wish(title="Ear buds",description="I want earbuds , oppo enco buds 2 to be specific"),
        Wish(title="Tshirts",description="I just love oversized baggy outfits"),
    )
}
