package com.example.apexdevs.fragments

import SharedViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apexdevs.R
import com.example.apexdevs.adapter.RecycleViewAdapter
import com.example.apexdevs.databinding.ActivityMainBinding
import com.example.apexdevs.databinding.FragmentMenuBinding
import com.example.apexdevs.models.RecycleViewModel

class MenuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecycleViewAdapter
    private lateinit var dataList: ArrayList<RecycleViewModel>
    private lateinit var binding: FragmentMenuBinding
    private val sharedViewModel by activityViewModels<SharedViewModel>()
//    private val dataList = ArrayList<RecycleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        dataList = ArrayList<RecycleViewModel>()

        sharedViewModel.dataArrayList.observe(viewLifecycleOwner, Observer { dataList ->
            adapter = RecycleViewAdapter(dataList, requireContext())
            binding.projectRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.projectRecyclerView.adapter = adapter
        })

        return view
    }
}