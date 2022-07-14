package com.example.android.politicalpreparedness.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.database.domainModels.DomainVoterInfoResult
import com.example.android.politicalpreparedness.network.CivicsApi
import com.example.android.politicalpreparedness.network.mapper.ApiToDomainMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VoterInfoViewModel(private val repository: ElectionsRepository) : ViewModel() {
    //DONE: Create live data val for upcoming elections
    private var _voterInfoResponse = MutableLiveData<List<DomainVoterInfoResult>>()

    //DONE: Create live data val for saved elections
    val voterInfoResponse: LiveData<List<DomainVoterInfoResult>>
        get() = _voterInfoResponse

    //TODO: Add var and methods to populate voter info

    //TODO: Add var and methods to support loading URLs

    //TODO: Add var and methods to save and remove elections to local database
    //TODO: cont'd -- Populate initial state of save button to reflect proper action based on election saved status

    /**
     * Hint: The saved state can be accomplished in multiple ways. It is directly related to how elections are saved/removed from the database.
     */

    /*
        This call is a bit ridiculous. You need to feed it an election Id as well as the zip from
        your location services.  The only way you can access links is if zip matches the ones of
        the election - then you can get link data.
     */


    fun callAPIForVoterInfo() {
        viewModelScope.launch {
            // ERROR: Crash occurs when you feed it an AZ zipcode instead of your SF one.
            val response = withContext(Dispatchers.IO) {
                CivicsApi.retrofitService.getVoterInfo("7226", 94107)
            }

            // ISSUE: Getting successs code 200 but contents are null.
            if (response.isSuccessful) {
                val domainVoterInfo =
                    // ERROR: ((Response)response).body = Expecting an element; looking at ERROR_ELEMENT
                    ApiToDomainMapper.mapFromAPIVoterInfoResponseToDomainVoterInfoResponse(response.body()!!) // DomainVoterInfoResult
                _voterInfoResponse.postValue(listOf(domainVoterInfo)) // VoterInfoResponse

                Log.d("VOTERSUCCESS", response.body().toString())
            } else {
                Log.d("ERROR", response.errorBody().toString())
            }
        }
    }
}