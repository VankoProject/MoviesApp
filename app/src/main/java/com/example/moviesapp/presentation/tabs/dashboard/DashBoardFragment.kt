package com.example.moviesapp.presentation.tabs.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDashBoardBinding
import com.example.moviesapp.presentation.tabs.adapters.mainadapter.MainMoviesAdapter
import com.example.moviesapp.presentation.tabs.adapters.mainadapter.MainViewHolder


class DashBoardFragment : Fragment(R.layout.fragment_dash_board) {

    private lateinit var binding: FragmentDashBoardBinding
    private val viewModel by viewModels<DashBoardViewModel>()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashBoardBinding.bind(view)

        val adapter = MainMoviesAdapter(requireContext())

        adapter.onMovieClickListener = object : MainMoviesAdapter.OnMovieClickListener {
            override fun onMovieClick(movieInfo: MainViewHolder) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_detailFragment)
            }

        }

        recyclerView = binding.rvMoviesList
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
        binding.rvMoviesList.itemAnimator = null

        adapter.onMovieClickListener = object : MainMoviesAdapter.OnMovieClickListener {
            override fun onMovieClick(movieInfo: MainViewHolder) {
                findNavController().navigate(R.id.action_dashBoardFragment_to_detailFragment)
            }

        }
        viewModel.moviePopularList.observe(viewLifecycleOwner) {
            adapter.submitList(it)

        }

        recyclerView = binding.rvMoviesList
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
        binding.rvMoviesList.itemAnimator = null
    }
}