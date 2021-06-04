package com.zekab.androidjetpacknavigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentStartScreenBinding

class StartScreenFragment : Fragment() {

    private lateinit var binding: FragmentStartScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickMethod()
    }

    private fun onClickMethod() {


        binding.btnPlay.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        }

        binding.btnScoreBord.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_startFragment_to_scoreFragment)
        }

    }

}