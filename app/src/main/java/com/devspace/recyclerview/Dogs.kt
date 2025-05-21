package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Dogs(
    val name : String,
    val breed : String,
    val age : String,
    val gender : String,
    val weight : String,
    val vaccine : String,
    val goodKids : String,
    val goodDogs : String,
    val bio : String,
    @DrawableRes val icon: Int
)
