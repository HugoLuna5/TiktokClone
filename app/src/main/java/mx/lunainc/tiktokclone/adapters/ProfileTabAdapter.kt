package mx.lunainc.tiktokclone.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import mx.lunainc.tiktokclone.ui.fragments.discover.DashboardFragment
import mx.lunainc.tiktokclone.ui.fragments.home.HomeFragment

class ProfileTabAdapter(
    var context: Context,
    fm: FragmentManager,
    var total: Int
) : FragmentPagerAdapter(fm) {


    override fun getCount() = total

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return DashboardFragment()
            }
            else -> getItem(position)
        }


    }


}