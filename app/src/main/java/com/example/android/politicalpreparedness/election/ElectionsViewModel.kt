package com.example.android.politicalpreparedness.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.network.CivicsApi
import com.example.android.politicalpreparedness.network.jsonadapter.Mapper
import com.example.android.politicalpreparedness.network.models.Election
import kotlinx.coroutines.launch

//DONE: Construct ViewModel and provide election datasource
class ElectionsViewModel(private val repository: ElectionsRepository): ViewModel() {

    //DONE: Create live data val for upcoming elections
    private var _electionResponse = MutableLiveData<List<Election>>()

    //DONE: Create live data val for saved elections
    val electionResponse: LiveData<List<Election>>
        get() = _electionResponse


    //TODO: Create val and functions to populate live data for upcoming elections from the API and saved elections from local database


    //TODO: Create functions to navigate to saved or upcoming election voter info

    init {

    }

    /*
    Make API Call
    Map Response to Domain Model
    Send Domain Model data to UI
     */
    fun callAPIForElections() {
        viewModelScope.launch {
           val elections =  Mapper.map(CivicsApi.retrofitService.getElections())
            _electionResponse.postValue(elections)
        }
    }


//    private fun getPictureOfTheDay() {
//        viewModelScope.launch {
//            try {
//                val pictureOfDay = PictureOfDayAPI.retrofitService.getPictureOfDay()
//                _pictureResponse.value = pictureOfDay
//            } catch (exception: Exception) {
//                print("Failure: ${exception.message}")
//            }
//        }
//    }
}
