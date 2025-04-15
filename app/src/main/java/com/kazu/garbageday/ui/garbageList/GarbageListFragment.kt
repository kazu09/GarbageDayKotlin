package com.kazu.garbageday.ui.garbageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kazu.garbageday.R
import com.kazu.garbageday.databinding.FragmentGarbageListBinding
import com.kazu.garbageday.ui.garbageList.adapter.GarbageMajorItemsAdapter
import com.kazu.garbageday.ui.garbageList.adapter.GarbageMajorItemsAdapter.ClickListener

class GarbageListFragment : Fragment() {

    private lateinit var binding: FragmentGarbageListBinding
    private val viewModel: GarbageListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGarbageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = binding.garbageButtonList

        val adapter = GarbageMajorItemsAdapter(viewModel.tags, object : ClickListener {
            override fun onClickItem(item: String) {
                val bundle = Bundle().apply {
                    putString("garbageType", item)
                }

                findNavController().navigate(R.id.navigation_garbageDetail, bundle)
            }
        })
        button.layoutManager = LinearLayoutManager(requireContext())
        button.adapter = adapter
    }
}