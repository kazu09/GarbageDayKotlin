package com.kazu.garbageday.ui.garbageDetail

import androidx.lifecycle.ViewModel
import com.kazu.garbageday.R
import com.kazu.garbageday.common.enums.Garbage
import com.kazu.garbageday.common.models.ColorSet
import com.kazu.garbageday.common.utils.ColorUtil

class GarbageDetailViewModel : ViewModel() {
    fun setupBarColor(type: String?, colorUtil: ColorUtil): ColorSet {
        type?.let {
            when (it) {
                Garbage.BurningGarbage.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_ffffff),
                        colorUtil.getColor(R.color.color_ff0000)
                    )
                }

                Garbage.PlasticTrash.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_0000cc),
                        colorUtil.getColor(R.color.color_bbffff)
                    )
                }

                Garbage.NoBurningGarbage.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_00aa00),
                        colorUtil.getColor(R.color.color_ffffaa)
                    )
                }

                Garbage.Bottles.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_ffffff),
                        colorUtil.getColor(R.color.color_a16eff)
                    )
                }

                Garbage.SmallMetal.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_ffffff),
                        colorUtil.getColor(R.color.color_aaaaaa)
                    )
                }

                Garbage.ResourceRecovery.type -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_ffffff),
                        colorUtil.getColor(R.color.color_cd853f)
                    )
                }

                else -> {
                    return ColorSet(
                        colorUtil.getColor(R.color.color_ffffff),
                        colorUtil.getColor(R.color.color_f4a460)
                    )
                }
            }
        }
        return ColorSet(
            colorUtil.getColor(R.color.color_ffffff),
            colorUtil.getColor(R.color.color_f4a460)
        )
    }
}