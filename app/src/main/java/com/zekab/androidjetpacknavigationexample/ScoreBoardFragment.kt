package com.zekab.androidjetpacknavigationexample


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zekab.androidjetpacknavigationexample.databinding.FragmentScoreBoardBinding

class ScoreBoardFragment : BaseFragment<FragmentScoreBoardBinding>() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_score_board)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true

            val userItem :UserItem
            if(GeneralUtils.getUserData(context as Activity).isNotEmpty()) {
                binding.tvNothing.visibility = View.GONE
                userItem = GeneralUtils.fromStringToObject(GeneralUtils.getUserData(context as Activity))
                binding.ivUser.setImageResource(userItem.uImage)
                binding.tvGender.text = "Gender: " + userItem.uGender
                binding.tvName.text ="Name: " + userItem.uName
                binding.tvWinningPoints.text = "Winning Game: ${userItem.winningPoints }"
                binding.tvLosePoints.text = "Lose Game: ${userItem.losePoints }"
            }else{
                binding.tvNothing.visibility = View.VISIBLE
            }

        }

    }

}