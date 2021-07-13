package com.zekab.androidjetpacknavigationexample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentMatchScreenBinding

class MatchScreenFragment : BaseFragment<FragmentMatchScreenBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_match_screen)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            val userItem: UserItem = GeneralUtils.fromStringToObject(GeneralUtils.getUserData(context as Activity))
            if (userItem.uGender=="Male"){
                binding.ivUser.setImageResource(R.drawable.icon_avatar_male)
                binding.ivOpponent.setImageResource(R.drawable.icon_avatar_female)
            }else{
                binding.ivUser.setImageResource(R.drawable.icon_avatar_female)
                binding.ivOpponent.setImageResource(R.drawable.icon_avatar_male)
            }
            onClickMethod()

        }

    }

    private fun onClickMethod() {
        binding.btnStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_matchFragment_to_gameTestFragment)
        }
    }

}