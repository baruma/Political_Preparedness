package com.example.android.politicalpreparedness.election

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
    private val voterInfoViewModel: VoterInfoViewModel by inject()
    lateinit var binding: FragmentVoterInfoBinding
    val args: VoterInfoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

//        Log.d("fail", "It fails here")
        //TODO: Add ViewModel values and create ViewModel

        //DONE: Add binding values
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voter_info, container, false)
        val root: View = binding.root

        //TODO: Populate voter info -- hide views without provided data.

        // Something still goes wrong here.  Also, try passing in data from Fragment?
        binding.electionName.election_name.text = args.pushElection.name
        //TODO: Handle loading of URLs

        //TODO: Handle save button UI state
        //TODO: cont'd Handle save button clicks

        return root
    }

    //TODO: Create method to load URL intents

}