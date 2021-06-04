package com.zekab.androidjetpacknavigationexample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentMatchScreenBinding
import com.zekab.androidjetpacknavigationexample.databinding.FragmentStartScreenBinding

class MatchScreenFragment : Fragment() {

    private lateinit var binding: FragmentMatchScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_match_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun onClickMethod() {
        binding.btnStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_matchFragment_to_gameTestFragment)
        }
    }

}