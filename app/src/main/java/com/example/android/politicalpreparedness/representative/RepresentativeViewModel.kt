package com.example.android.politicalpreparedness.representative

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.database.ElectionsRepository
import com.example.android.politicalpreparedness.models.DomainVoterInfoResult
import com.example.android.politicalpreparedness.network.CivicsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepresentativeViewModel(private val repository: ElectionsRepository): ViewModel() {

    private var _representative = MutableLiveData<List<DomainVoterInfoResult>>()
    val representative: LiveData<List<DomainVoterInfoResult>>
        get() = _representative

    init {}

    //TODO: Establish live data for representatives and address

    //TODO: Create function to fetch representatives from API from a provided address

    /**
     *  The following code will prove helpful in constructing a representative from the API. This code combines the two nodes of the RepresentativeResponse into a single official :

    val (offices, officials) = getRepresentativesDeferred.await()
    _representatives.value = offices.flatMap { office -> office.getRepresentatives(officials) }

    Note: getRepresentatives in the above code represents the method used to fetch data from the API
    Note: _representatives in the above code represents the established mutable live data housing representatives

     */

    //TODO: Create function get address from geo location

    //TODO: Create function to get address from individual fields

    // TODO : LEFT OFF HERE.  NEED TO CALL THIS FUNCTION SOMEWHERE.  FINISH THE ERRORS WITH MAPPING THAT ARE BOUND TO COME.  DON'T NEED TO SAVE THE DATA.
    // TODO: GOT TO SET UP LOCATION SERVICES TO GRAB YOUR INFO.
    // Required value 'id' missing at $.divisions

    fun callAPIForRepresentatives() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                CivicsApi.retrofitService.getRepresentatives(94107)
            }
            if (response.isSuccessful) {
//                val representatives =
//                    ApiToDomainMapper.mapFromAPIRepresentativeToDomainRepresentative(response.body()!!, State("ma", AdministrationBody("", "", "", "", Address("", "", "", "", "", ""))))
                Log.d("payload", response.toString())
            } else {
                Log.d("", response.errorBody().toString())
            }
        }
    }

}
