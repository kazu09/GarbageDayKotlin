package com.kazu.garbageday.ui.garbageDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kazu.garbageday.R
import com.kazu.garbageday.common.utils.ColorUtil
import com.kazu.garbageday.common.utils.ToolbarUtil
import com.kazu.garbageday.databinding.FragmentGarbageDetailBinding

class GarbageDetailFragment : Fragment() {
    private lateinit var binding: FragmentGarbageDetailBinding
    private val viewModel: GarbageDetailViewModel by viewModels()
    private lateinit var colorUtil: ColorUtil

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGarbageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorUtil = ColorUtil(requireContext())
        val receivedGarbageType = arguments?.getString("garbageType")
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_common)

        val toolbarIconAndTextColor: Int
        val backgroundColor: Int
        when (receivedGarbageType) {
            "燃えるゴミ" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_ffffff)
                backgroundColor = colorUtil.getColor(R.color.color_ff0000)
            }
            "プラスチック資源" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_0000cc)
                backgroundColor = colorUtil.getColor(R.color.color_bbffff)
            }
            "燃えないゴミ" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_00aa00)
                backgroundColor = colorUtil.getColor(R.color.color_ffffaa)
            }
            "缶・瓶・ペットボトル" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_ffffff)
                backgroundColor = colorUtil.getColor(R.color.color_a16eff)
            }
            "小さな金属" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_ffffff)
                backgroundColor = colorUtil.getColor(R.color.color_aaaaaa)
            }
            "資源回収" -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_ffffff)
                backgroundColor = colorUtil.getColor(R.color.color_cd853f)
            }
            else -> {
                toolbarIconAndTextColor = colorUtil.getColor(R.color.color_ffffff)
                backgroundColor = colorUtil.getColor(R.color.color_bbffff)
            }
        }

        ToolbarUtil.setupWithBackButton(toolbar,
            IS_SHOW_BACK_BUTTON,
            findNavController(),
            requireContext(),
            receivedGarbageType,
            backgroundColor,
            toolbarIconAndTextColor)

        ToolbarUtil.setupStatusBar(
            requireActivity(),
            backgroundColor
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        val defaultColor = colorUtil.getColor(R.color.color_f4a460)
        ToolbarUtil.setupStatusBar(
            requireActivity(),
            defaultColor
        )
    }

    companion object {
        const val IS_SHOW_BACK_BUTTON = true
    }
}