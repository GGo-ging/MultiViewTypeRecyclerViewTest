package com.example.multiviewtyperecyclerview.data

import android.os.Parcelable
import com.example.multiviewtyperecyclerview.presentation.MultiViewEnum
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

//@Parcelize 키워드 사용 시 build gradle 추가
@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class UserEntity(
    val name : String,
    val age : Int,
    val cardNumber : String,
    val cardPeriod : String,
    val balance : BigDecimal,
    val cardType : MultiViewEnum
) : Parcelable
