package com.kazu.garbageday.ui.garbageList

import androidx.lifecycle.ViewModel

class GarbageListViewModel : ViewModel() {
    val tags = listOf(
        "燃えるゴミ",
        "プラスチック資源",
        "燃えないゴミ",
        "缶・瓶・ペットボトル",
        "小さな金属",
        "資源回収"
    )
}