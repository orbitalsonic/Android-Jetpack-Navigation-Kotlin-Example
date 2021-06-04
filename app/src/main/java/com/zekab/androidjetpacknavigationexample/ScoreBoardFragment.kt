package com.zekab.androidjetpacknavigationexample

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zekab.androidjetpacknavigationexample.databinding.FragmentScoreBoardBinding

class ScoreBoardFragment : Fragment() {

    private lateinit var binding: FragmentScoreBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_board, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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