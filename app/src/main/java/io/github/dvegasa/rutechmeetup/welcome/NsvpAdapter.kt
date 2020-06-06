package io.github.dvegasa.rutechmeetup.welcome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Ed Khalturin @DVegasa
 */
class NsvpAdapter(val list: List<Fragment>, val fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = list[position]

    override fun getCount() = list.size
}