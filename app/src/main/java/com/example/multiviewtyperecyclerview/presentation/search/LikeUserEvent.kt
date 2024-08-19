package com.example.multiviewtyperecyclerview.presentation.search

import com.example.multiviewtyperecyclerview.data.database.remote.ImageDocumentResponse


interface LikeUserEvent {
    fun likeUser(item : ImageDocumentResponse)
}