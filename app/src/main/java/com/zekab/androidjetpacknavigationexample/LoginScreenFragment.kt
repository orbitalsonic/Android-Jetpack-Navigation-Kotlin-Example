package com.zekab.androidjetpacknavigationexample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zekab.androidjetpacknavigationexample.databinding.FragmentLoginScreenBinding

class LoginScreenFragment : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var userItem: UserItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialData()
        onClickMethod()
    }

    private fun onClickMethod() {

        binding.btnLogin.setOnClickListener { view: View ->
            if (validateText()) {
                settingData()
                view.findNavController().navigate(R.id.action_loginFragment_to_matchFragment)
            }

        }

        binding.radioMale.setOnClickListener {
            if (binding.radioMale.isChecked) {
                binding.ivUser.setImageResource(R.drawable.icon_avatar_male)
            }
        }

        binding.radioFemale.setOnClickListener {
            if (binding.radioFemale.isChecked) {
                binding.ivUser.setImageResource(R.drawable.icon_avatar_female)
            }
        }
    }

    private fun validateText(): Boolean {
        val textInput: String =
            binding.nameInputLayout.editText?.text.toString()
        return if (textInput.isEmpty()) {
            binding.nameInputLayout.error = "Field can't be empty"
            false
        } else {
            binding.nameInputLayout.error = null
            true
        }
    }

    private fun initialData(){
        userItem = if (GeneralUtils.getUserData(context as Activity).isNotEmpty()) {
            GeneralUtils.fromStringToObject(GeneralUtils.getUserData(context as Activity))
        } else {
            UserItem("Ali", "Male", R.drawable.icon_avatar_male, 0,0)
        }

        binding.ivUser.setImageResource(userItem.uImage)
        binding.nameInputLayout.editText?.setText(userItem.uName)
        if (userItem.uGender=="Male"){
            binding.radioMale.isChecked = true
        }else{
            binding.radioFemale.isChecked = true
        }
    }

    private fun settingData() {

        if (binding.radioMale.isChecked) {
            userItem.uGender = "Male"
            userItem.uImage = R.drawable.icon_avatar_male
        } else {
            userItem.uGender = "Female"
            userItem.uImage = R.drawable.icon_avatar_female
        }
        userItem.uName = binding.nameInputLayout.editText?.text.toString()

        GeneralUtils.setUserData(context as Activity, GeneralUtils.fromObjectToString(userItem))


    }

}