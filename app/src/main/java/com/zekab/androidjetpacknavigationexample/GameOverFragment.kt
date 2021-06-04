package com.zekab.androidjetpacknavigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentGameOverScreenBinding

class GameOverFragment : Fragment() {

    private lateinit var binding: FragmentGameOverScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game_over_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickMethod()
    }

    private fun onClickMethod() {
        binding.btnTryAgain.setOnClickListener { view: View ->
//            view.findNavController().popBackStack(R.id.matchFragment,false)
            view.findNavController().navigate(R.id.action_gameOverFragment_to_matchFragment)
        }
        binding.btnExit.setOnClickListener { view: View ->
//            view.findNavController().popBackStack(R.id.startFragment,true)
            view.findNavController().navigate(R.id.action_gameOverFragment_to_startFragment)
        }
    }

}