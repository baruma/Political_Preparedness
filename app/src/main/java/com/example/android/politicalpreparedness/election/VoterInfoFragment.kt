package com.example.android.politicalpreparedness.election

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.android.politicalpreparedness.R
import com.example.android.politicalpreparedness.databinding.FragmentVoterInfoBinding
import kotlinx.android.synthetic.main.election_view_holder.view.*
import org.koin.android.ext.android.inject

class VoterInfoFragment : Fragment() {
    //DONE: Add ViewModel values and create ViewModel
    private val voterInfoViewModel: VoterInfoViewModel by inject()
    private val electionsViewModel: ElectionsViewModel by inject()

    lateinit var binding: FragmentVoterInfoBinding
    val args: VoterInfoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        //DONE: Add binding values
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voter_info, container, false)
        val root: View = binding.root

        //DONE: Populate voter info -- hide views without provided data.

//        binding.electionName.title = args.pushElection.name
//        binding.electionDate.text = args.pushElection.electionDay.toString()
        // ballots
        // TODO: Replace unsafe optional calls here.
        // TODO: Figure out how to get objects from database.  Flow: give room a domain object, room gets confused and asks for string, you must give it a string, which will find the domain object's room counterpart.
//        binding.stateBallot.text = args.pushElection.division!!.state!!.administrationBody!!.ballotInfoURL
        binding.stateBallot.setOnClickListener {
            getUrlFromIntent(view!!)
        }
        // locations
//        binding.stateLocations.text = args.pushElection.division!!.state!!.administrationBody!!.votingLocationURL

        //TODO: Handle loading of URLs (voting location and ballot information)

        //TODO: Handle save button UI state
        //TODO: cont'd Handle save button clicks

        return root
    }

    private fun getUrlFromIntent(view: View) {
        val url = "http://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    //TODO: Create method to load URL intents

}