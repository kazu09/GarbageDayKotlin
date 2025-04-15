package com.kazu.garbageday.common.utils

import android.content.Context
import androidx.core.content.ContextCompat

class  ColorUtil(private val context: Context) {
    fun getColor(color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}