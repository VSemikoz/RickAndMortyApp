package ru.vssemikoz.rickandmortyapp.utils

import androidx.core.util.Preconditions
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object ActivityUtils {
    fun addFragmentToActivity(
        fragmentManager: FragmentManager, fragment: Fragment, containerId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(containerId, fragment)
        transaction.commit()
    }
}
