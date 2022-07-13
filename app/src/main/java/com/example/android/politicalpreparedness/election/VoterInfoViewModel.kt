package com.example.android.politicalpreparedness.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.database.ElectionDao
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.network.CivicsApi
import com.example.android.politicalpreparedness.network.models.State
import com.example.android.politicalpreparedness.network.models.VoterInfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VoterInfoViewModel(private val repository: ElectionsRepository) : ViewModel() {
    //DONE: Create live data val for upcoming elections
    private var _voterInfoResponse = MutableLiveData<List<VoterInfoResponse>>()

    //DONE: Create live data val for saved elections
    val electionResponse: LiveData<List<VoterInfoResponse>>
        get() = _voterInfoResponse

    //TODO: Add var and methods to populate voter info

    //TODO: Add var and methods to support loading URLs

    //TODO: Add var and methods to save and remove elections to local database
    //TODO: cont'd -- Populate initial state of save button to reflect proper action based on election saved status

    /**
     * Hint: The saved state can be accomplished in multiple ways. It is directly related to how elections are saved/removed from the database.
     */

    // TODO: Call for VoterInfo
    fun callAPIForVoterInfo() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                CivicsApi.retrofitService.getVoterInfo("7226", 94107)
            }

            if (response.isSuccessful) {
                Log.d("VOTERSUCCESS", response.body().toString())
            } else {
                Log.d("ERROR", response.errorBody().toString())
            }
        }
    }
}

// 1. Declare API Call here.
// 2. Call function in VoterInfo Fragment.

//2022-07-11 13:22:54.656 16984-16984/com.example.android.politicalpreparedness D/VOTERSUCCESS: VoterInfoResponse(kind=civicinfo#voterInfoResponse, election=ElectionAPIModel(id=7226, name=Arizona Primary Election, electionDay=Tue Aug 02 00:00:00 PDT 2022, division=ocd-division/country:us/state:az), otherElections=[], normalizedInput=NormalizedInput(locationName=null, line1=, line2=null, line3=null, city=San Francisco, state=CA, zip=94107), pollingLocations=[], earlyVoteSites=[], dropOffLocation=[], contests=[], state=[State(name=California, electionAdministrationBody=AdministrationBody(name=Secretary of State, electionInfoUrl=http://www.sos.ca.gov/elections/, votingLocationFinderUrl=https://voterstatus.sos.ca.gov, ballotInfoUrl=https://www.sos.ca.gov/elections/ballot-status/wheres-my-ballot/, correspondenceAddress=Address(locationName=, line1=1500 11th Street, 5th Floor, line2=, city=Sacramento, state=California, zip=95814)))], electionElectionOfficials=[], mailOnly=null)
