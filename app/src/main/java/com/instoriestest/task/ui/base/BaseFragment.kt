package com.instoriestest.task.ui.base

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import moxy.MvpAppCompatFragment

abstract class BaseFragment(layoutId: Int): MvpAppCompatFragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView()
    }

    fun getNavController() = findNavController()

    abstract fun onInitView()
}