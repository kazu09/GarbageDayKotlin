package com.kazu.garbageday.common.enums

import com.kazu.garbageday.common.constants.CommonConstants

enum class Garbage(val id: Int, val type: String) {
    BurningGarbage(0, CommonConstants.Garbage.BURNING_GARBAGE),
    PlasticTrash(1, CommonConstants.Garbage.PLASTIC_TRASH),
    NoBurningGarbage(2,CommonConstants.Garbage.NO_BURNING_GARBAGE),
    Bottles(3,CommonConstants.Garbage.BOTTLES),
    SmallMetal(4,CommonConstants.Garbage.SMALL_METAL),
    ResourceRecovery(5,CommonConstants.Garbage.RESOURCE_RECOVERY)
}