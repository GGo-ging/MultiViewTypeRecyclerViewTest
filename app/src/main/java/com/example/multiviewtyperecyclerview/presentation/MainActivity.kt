package com.example.multiviewtyperecyclerview.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowerrecyclerview.data.DataSource
import com.example.multiviewtyperecyclerview.data.UserEntity
import com.example.multiviewtyperecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val multiCardAdapter : MultiCardAdapter by lazy {
        MultiCardAdapter { userentity ->
            adapterOnClick(userentity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cardList = DataSource.getDataSource().getCardList()
        multiCardAdapter.cardList = cardList

        with(binding.rvItem) {
            adapter = multiCardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun adapterOnClick(card : UserEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}