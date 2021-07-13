package com.zekab.androidjetpacknavigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentWinnerScreenBinding

class WinnerFragment : BaseFragment<FragmentWinnerScreenBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_winner_screen)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            onClickMethod()

        }

    }


    private fun onClickMethod() {
        binding.btnNextMatch.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_winnerFragment_to_matchFragment)
        }

        binding.btnScoreBord.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_winnerFragment_to_scoreFragment)
        }

        binding.btnExit.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_winnerFragment_to_startFragment)
        }
    }

}