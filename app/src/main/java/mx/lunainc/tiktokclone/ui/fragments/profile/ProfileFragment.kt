package mx.lunainc.tiktokclone.ui.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import mx.lunainc.tiktokclone.R
import mx.lunainc.tiktokclone.adapters.ProfileTabAdapter
import mx.lunainc.tiktokclone.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import mx.lunainc.tiktokclone.ui.activities.edit.EditProfileActivity

class ProfileFragment : Fragment() {


    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        configViews()

        events()
        return binding.root
    }


    private fun configViews() {
        binding.tab.addTab(binding.tab.newTab().setText("").setIcon(R.drawable.ic_tab))
        binding.tab.addTab(binding.tab.newTab().setText("").setIcon(R.drawable.heart))
        //binding.tab.tabGravity = TabLayout.GRAVITY_CENTER
        val adapter =
            ProfileTabAdapter(requireContext(), parentFragmentManager, binding.tab.tabCount)
        binding.viewpager.adapter = adapter
        binding.viewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tab))
        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    private fun events() {
        binding.editProfile.setOnClickListener {
            startActivity(Intent(activity, EditProfileActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}