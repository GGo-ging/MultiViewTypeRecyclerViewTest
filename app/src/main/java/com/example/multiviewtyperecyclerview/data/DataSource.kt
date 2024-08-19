package com.example.flowerrecyclerview.data

import com.example.multiviewtyperecyclerview.data.UserEntity


class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<UserEntity> {
        return cardList()
    }

}