package com.kazu.garbageday.ui.garbageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kazu.garbageday.R
import com.kazu.garbageday.common.enums.Garbage
import com.kazu.garbageday.common.models.ColorSet
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
        val color: ColorSet
        when (position) {
            Garbage.BurningGarbage.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_ffffff),
                    colorUtil.getColor(R.color.color_ff0000)
                )
            }

            Garbage.PlasticTrash.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_0000cc),
                    colorUtil.getColor(R.color.color_bbffff)
                )
            }

            Garbage.NoBurningGarbage.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_00aa00),
                    colorUtil.getColor(R.color.color_ffffaa)
                )
            }

            Garbage.Bottles.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_ffffff),
                    colorUtil.getColor(R.color.color_a16eff)
                )
            }

            Garbage.SmallMetal.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_ffffff),
                    colorUtil.getColor(R.color.color_aaaaaa)
                )
            }

            Garbage.ResourceRecovery.id -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_ffffff),
                    colorUtil.getColor(R.color.color_cd853f)
                )
            }

            else -> {
                color = ColorSet(
                    colorUtil.getColor(R.color.color_ffffff),
                    colorUtil.getColor(R.color.color_f4a460)
                )
            }
        }
        holder.binding.garbageButtonText.setTextColor(color.textColor)
        holder.binding.garbageButton.setBackgroundColor(color.backgroundColor)
    }

    inner class ViewHolder(val binding: GarbageButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}