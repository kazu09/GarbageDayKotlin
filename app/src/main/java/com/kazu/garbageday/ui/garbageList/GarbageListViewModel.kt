package com.kazu.garbageday.ui.garbageList

import androidx.lifecycle.ViewModel
import com.kazu.garbageday.common.constants.CommonConstants

class GarbageListViewModel : ViewModel() {
    val garbageTags = listOf(
        CommonConstants.Garbage.BURNING_GARBAGE,
        CommonConstants.Garbage.PLASTIC_TRASH,
        CommonConstants.Garbage.NO_BURNING_GARBAGE,
        CommonConstants.Garbage.BOTTLES,
        CommonConstants.Garbage.SMALL_METAL,
        CommonConstants.Garbage.RESOURCE_RECOVERY
    )
}