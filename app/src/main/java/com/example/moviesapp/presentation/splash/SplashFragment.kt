package com.example.moviesapp.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.moviesapp.R


class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({
            findNavController().navigate(
                R.id.action_splashFragment_to_tabsFragment,
                null,
                navOptions {
                    anim {
                        enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                        popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                        popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                        exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                    }
                }
            )
        }, 3000)
    }


}