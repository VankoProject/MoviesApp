package com.example.moviesapp.presentation.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSignInBinding


class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        binding.btnLogin.setOnClickListener {

        }
    }


}