package com.kazu.garbageday.ui.garbageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kazu.garbageday.R
import com.kazu.garbageday.common.utils.ColorUtil
import com.kazu.garbageday.databinding.GarbageButtonItemBinding

class GarbageMajorItemsAdapter(
    private val items: List<String>,
    private val listener: ClickListener
) : RecyclerView.Adapter<GarbageMajorItemsAdapter.ViewHolder>() {

    private lateinit var colorUtil: ColorUtil

    interface ClickListener {
        fun onClickItem(item: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GarbageButtonItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        colorUtil = ColorUtil(holder.itemView.context)
        holder.binding.garbageButtonText.text = items[position]
        setButtonColor(position, holder)
        // タップ処理追加したい場合はここでリスナー設定
        holder.binding.garbageButton.setOnClickListener {
            listener.onClickItem(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    private fun setButtonColor(position: Int, holder: GarbageMajorItemsAdapter.ViewHolder) {
        val buttonTextColor: Int
        val buttonBackgroundColor: Int
        when (position) {
            BURNING_GARBAGE -> {
                buttonTextColor = colorUtil.getColor(R.color.color_ffffff)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_ff0000)
            }

            PLASTIC_TRASH -> {
                buttonTextColor = colorUtil.getColor(R.color.color_0000cc)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_bbffff)
            }

            NON_BURNING_GARBAGE -> {
                buttonTextColor = colorUtil.getColor(R.color.color_00aa00)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_ffffaa)
            }

            BOTTLES -> {
                buttonTextColor = colorUtil.getColor(R.color.color_ffffff)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_a16eff)
            }

            SMALL_METAL -> {
                buttonTextColor = colorUtil.getColor(R.color.color_ffffff)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_aaaaaa)
            }

            RESOURCE_RECOVERY -> {
                buttonTextColor = colorUtil.getColor(R.color.color_ffffff)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_cd853f)
            }

            else -> {
                buttonTextColor = colorUtil.getColor(R.color.color_ffffff)
                buttonBackgroundColor = colorUtil.getColor(R.color.color_bbffff)
            }
        }
        holder.binding.garbageButtonText.setTextColor(buttonTextColor)
        holder.binding.garbageButton.setBackgroundColor(buttonBackgroundColor)
    }

    companion object {
        const val BURNING_GARBAGE = 0
        const val PLASTIC_TRASH = 1
        const val NON_BURNING_GARBAGE = 2
        const val BOTTLES = 3
        const val SMALL_METAL = 4
        const val RESOURCE_RECOVERY = 5
    }

    inner class ViewHolder(val binding: GarbageButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}