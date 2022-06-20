package com.example.android.politicalpreparedness.election

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.network.CivicsApi
import com.example.android.politicalpreparedness.network.jsonadapter.Mapper
import kotlinx.coroutines.launch

//DONE: Construct ViewModel and provide election datasource
class ElectionsViewModel(private val repository: ElectionsRepository): ViewModel() {

    //DONE: Create live data val for upcoming elections
    private var _electionResponse = MutableLiveData<List<DomainElection>>()

    //DONE: Create live data val for saved elections
    val electionResponse: LiveData<List<DomainElection>>
        get() = _electionResponse


    //TODO: Create val and functions to populate live data for upcoming elections from the API and saved elections from local database


    //TODO: Create functions to navigate to saved or upcoming election voter info

    init {

    }

    fun callAPIForElections() {
        viewModelScope.launch {
            val domainElections = Mapper.mapFromElectionResponseToDomainElection(CivicsApi.retrofitService.getElections())
            // map this from election response to domain election list
            _electionResponse.postValue(domainElections)
        }
    }
}