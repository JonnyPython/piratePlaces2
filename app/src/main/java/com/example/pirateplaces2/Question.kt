package com.example.pirateplaces2

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)
data class names(@StringRes val nametextResId: Int, val answer: Boolean)