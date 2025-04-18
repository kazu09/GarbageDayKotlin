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
import com.kazu.garbageday.common.constants.CommonConstants
import com.kazu.garbageday.common.models.ColorSet
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
        val receivedGarbageType = arguments?.getString(CommonConstants.Bundle.GARBAGE_TYPE)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_common)
        val color: ColorSet = viewModel.setupBarColor(receivedGarbageType, colorUtil)
        initBackButton(toolbar, receivedGarbageType, color)
        initStatusBar(color)

    }

    override fun onDestroy() {
        super.onDestroy()
        val defaultColor = colorUtil.getColor(R.color.color_f4a460)
        ToolbarUtil.setupStatusBar(
            requireActivity(),
            defaultColor
        )
    }

    private fun initBackButton(
        toolbar: Toolbar,
        type: String?,
        color: ColorSet
    ) {
        ToolbarUtil.setupWithBackButton(
            toolbar,
            IS_SHOW_BACK_BUTTON,
            findNavController(),
            requireContext(),
            type,
            color.backgroundColor,
            color.textColor
        )
    }

    private fun initStatusBar(color: ColorSet) {
        ToolbarUtil.setupStatusBar(
            requireActivity(),
            color.backgroundColor
        )
    }

    companion object {
        const val IS_SHOW_BACK_BUTTON = true
    }
}