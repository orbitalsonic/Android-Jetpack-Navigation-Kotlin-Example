package com.zekab.androidjetpacknavigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zekab.androidjetpacknavigationexample.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment<FragmentAboutBinding>() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_about)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            onClickMethod()

        }

    }


    private fun onClickMethod() {
//        binding.btnPlay.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }
    }

}