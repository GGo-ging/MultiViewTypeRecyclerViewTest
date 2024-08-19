package com.example.multiviewtyperecyclerview.presentation.base

import com.example.multiviewtyperecyclerview.data.database.UserEntity

interface UserRepository {
    fun getUserList() : List<UserEntity>
}