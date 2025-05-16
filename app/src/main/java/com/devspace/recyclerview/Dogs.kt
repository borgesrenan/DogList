package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Dogs(
    val name : String,
    val breed : String,
    @DrawableRes val icon: Int
)
