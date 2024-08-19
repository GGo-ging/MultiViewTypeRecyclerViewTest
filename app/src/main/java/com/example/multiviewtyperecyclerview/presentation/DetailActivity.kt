package com.example.multiviewtyperecyclerview.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multiviewtyperecyclerview.data.UserEntity
import com.example.multiviewtyperecyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CARD: String = "extra_card"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val cardItem = intent.getParcelableExtra<UserEntity>(EXTRA_CARD)

        binding.detailName.text = cardItem!!.name
        binding.detailCardNum.text = cardItem.cardNumber
        binding.detailPeiod.text = cardItem.cardPeriod
        binding.detailViewType.text = cardItem.cardType.name
        
    }
}