package com.example.android.politicalpreparedness.election.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.politicalpreparedness.R
import com.example.android.politicalpreparedness.models.DomainElection
import com.example.android.politicalpreparedness.databinding.ElectionViewHolderBinding
import com.example.android.politicalpreparedness.election.ElectionOnClickInterface
import com.example.android.politicalpreparedness.election.ElectionsFragmentDirections
import java.util.*

// Are there good alternatives to passing viewmodels to adapters from their corresponding fragments?
// Lambda doesn't work here - it passes actions, not data.
class ElectionListAdapter(): ListAdapter<DomainElection, ElectionViewHolder>(ElectionDiffCallback) {
    //DONE: Add companion object to inflate ViewHolder (from)
    //DONE: Create ElectionDiffCallback
    companion object ElectionDiffCallback : DiffUtil.ItemCallback<DomainElection>() {

        override fun areItemsTheSame(oldItem: DomainElection, newItem: DomainElection): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DomainElection, newItem: DomainElection): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectionViewHolder {
        val binding: ElectionViewHolderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.election_view_holder,
            parent,
            false
        )

        return ElectionViewHolder(binding)
    }

    //TODO: Bind ViewHolder
    override fun onBindViewHolder(holder: ElectionViewHolder, position: Int) {
        val election = getItem(position)
        val bundle = Bundle()

//        }

        holder.bind(getItem(position))
    }

}

// Each ViewHolder should contain their own view - it shouldnt have to be a responsibility given to the Adapter
//DONE: Create ElectionViewHolder

//DONE: Create ElectionListener
// TODO: Refactor this so you're passing Lambdas.  Not viewModels.
class ElectionViewHolder(private val binding: ElectionViewHolderBinding)
    : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
    private val mCommunicator: ElectionOnClickInterface? = null
    val bundle = Bundle()

    // nested inside the UserAdapter class to keep things tidy

    // DONE: Make XML first to generate binding
    // DONE: Connect XML to This ViewHolder
    var electionEntityToPush: DomainElection? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(domainElection: DomainElection) {
        binding.election = domainElection
        electionEntityToPush = domainElection
        binding.executePendingBindings()
    }

    override fun onClick(view: View?) {
        val currentDate = Calendar.getInstance()

        view!!.findNavController().navigate(ElectionsFragmentDirections.actionElectionsFragmentToVoterInfoFragment(electionEntityToPush!!))
    }

}
