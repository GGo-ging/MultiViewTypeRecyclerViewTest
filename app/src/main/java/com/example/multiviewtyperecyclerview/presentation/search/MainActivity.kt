package com.example.multiviewtyperecyclerview.presentation.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multiviewtyperecyclerview.R
import com.example.multiviewtyperecyclerview.data.database.remote.ImageDocumentResponse
import com.example.multiviewtyperecyclerview.databinding.ActivityMainFragmentContainerBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() ,LikeUserEvent {
    private val binding: ActivityMainFragmentContainerBinding by lazy {
        ActivityMainFragmentContainerBinding.inflate(layoutInflater)
    }

    private var favoriteUser : ImageDocumentResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
    }

    private fun setFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, FirstFragment.newInstance())
            .commit()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text.toString()) {
                    "first" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view, FirstFragment.newInstance())
                            .commit()
                    }

                    "second" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.fragment_container_view,
                                SecondFragment.newInstance(favoriteUser)
                            )
                            .commit()

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    override fun likeUser(item: ImageDocumentResponse) {
        favoriteUser = item
    }
}