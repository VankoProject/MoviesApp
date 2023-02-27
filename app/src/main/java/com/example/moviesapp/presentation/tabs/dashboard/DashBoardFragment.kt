package com.example.moviesapp.presentation.tabs.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment(R.layout.fragment_dash_board) {

    private lateinit var binding: FragmentDashBoardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashBoardBinding.bind(view)
        binding.btnDetail.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_detailFragment)
        }

    }

}