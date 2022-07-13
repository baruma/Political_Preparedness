package com.example.android.politicalpreparedness.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.politicalpreparedness.R
import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.databinding.FragmentElectionBinding
import com.example.android.politicalpreparedness.election.adapter.ElectionListAdapter
import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import org.koin.android.ext.android.inject

interface ElectionOnClickInterface {
    fun electionOnClick(position: Int, electionEntity: ElectionEntity?)
}

class ElectionsFragment: Fragment() {

    //DONE: Declare ViewModel
    private val electionsListViewModel: ElectionsViewModel by inject()
    lateinit var binding: FragmentElectionBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerAdapter: ElectionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //DONE: Add ViewModel values and create ViewModel
//        binding = FragmentElectionBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_election, container, false)

        val root: View = binding.root

        recyclerAdapter = ElectionListAdapter()
        linearLayoutManager = LinearLayoutManager(context)

        binding.upcomingElectionsRecyclerView.layoutManager = linearLayoutManager
        binding.upcomingElectionsRecyclerView.adapter = recyclerAdapter


        //TODO: Add binding values

        //TODO: Link elections to voter info

        //TODO: Initiate recycler adapters

        //TODO: Populate recycler adapters

        // Observer
        val observer: Observer<List<DomainElection>> =
            Observer<List<DomainElection>> { elections ->
                recyclerAdapter.submitList(elections)
            }

        // Observe
        electionsListViewModel.electionResponse.observe(viewLifecycleOwner, observer)

        electionsListViewModel.callAPIForElections()
//        electionsListViewModel.callAPIForVoterInfo()

        return root
    }

    private fun handleElectionData(electionEntity: ElectionEntity) {

    }

    //TODO: Refresh adapters when fragment loads
    fun refreshAdapters() {
        recyclerAdapter.notifyDataSetChanged()
    }

}