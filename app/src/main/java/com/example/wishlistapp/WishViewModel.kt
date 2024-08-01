package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
): ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString:String){
        wishTitleState=newString
    }
    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes : Flow<List<Wish>>    //since Flow works asynchronously, the variable may take some time to be created, by using 'lateinit'
                                                    //we are giving a promise that the variable will be accessed only when it is created. This prevents
                                                    //us from implementing null check every time for the variable\
//An init block is a special block of code that is executed when an instance of the class is created. You can have multiple init blocks in a class, and they will be executed in the order they appear, interleaved with the property initializations.
//   Launch: This function launches a new coroutine in the viewModelScope. Coroutines allow for asynchronous operations, enabling you to perform tasks like fetching data from a database without blocking the main thread
    init {
        viewModelScope.launch {
            getAllWishes=wishRepository.getWishes()
        }
    }

//    Dispatchers in Kotlin coroutines determine which thread or threads are used to execute a coroutine. They manage where and how coroutines run, like choosing between the main thread (UI thread) and background threads for tasks.
    fun addWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish)
        }
    }

    fun updateWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }
    fun deleteWish(wish:Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }
    fun getAWishById(id:Long):Flow<Wish>{
        return wishRepository.getAWishById(id)
    }
}