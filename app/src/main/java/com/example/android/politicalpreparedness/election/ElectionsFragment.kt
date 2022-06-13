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
import com.example.android.politicalpreparedness.databinding.FragmentElectionBinding
import com.example.android.politicalpreparedness.election.adapter.ElectionListAdapter
import com.example.android.politicalpreparedness.network.models.Election
import org.koin.android.ext.android.inject

interface ElectionOnClickInterface {
    fun electionOnClick(position: Int, election: Election?)
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

        val observer: Observer<List<Election>> =
            Observer<List<Election>> { elections ->
                recyclerAdapter.submitList(elections)
            }

        electionsListViewModel.electionResponse.observe(viewLifecycleOwner, observer)

        electionsListViewModel.callAPIForElections()

        return root
    }

    private fun handleElectionData(election: Election) {

    }

    //TODO: Refresh adapters when fragment loads
    fun refreshAdapters() {
        recyclerAdapter.notifyDataSetChanged()
    }

}