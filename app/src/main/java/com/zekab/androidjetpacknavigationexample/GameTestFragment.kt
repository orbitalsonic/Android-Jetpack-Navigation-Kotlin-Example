package com.zekab.androidjetpacknavigationexample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentGameTestScreenBinding

class GameTestFragment : Fragment() {

    private lateinit var binding: FragmentGameTestScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_test_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickMethod()
    }

    private fun onClickMethod() {
        binding.btnSubmit.setOnClickListener { view: View ->
            if (binding.answerOne.isChecked){
                matchScoreSetting(true)
                view.findNavController().navigate(R.id.action_gameTestFragment_to_winnerFragment)
            }else{
                matchScoreSetting(false)
                view.findNavController().navigate(R.id.action_gameTestFragment_to_gameOverFragment)
            }

        }
    }

    private fun matchScoreSetting(isWinning:Boolean){
        val userItem: UserItem = GeneralUtils.fromStringToObject(GeneralUtils.getUserData(context as Activity))
        if(isWinning){
            userItem.winningPoints= userItem.winningPoints + 1
        }else{
            userItem.losePoints = userItem.losePoints + 1
        }

        GeneralUtils.setUserData(context as Activity,GeneralUtils.fromObjectToString(userItem))
    }

}