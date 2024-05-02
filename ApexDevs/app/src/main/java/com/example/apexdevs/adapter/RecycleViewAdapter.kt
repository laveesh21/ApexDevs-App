package com.example.apexdevs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apexdevs.R
import com.example.apexdevs.databinding.ProjectCardRecycleViewBinding
import com.example.apexdevs.models.RecycleViewModel

class RecycleViewAdapter(var dataList: ArrayList<RecycleViewModel>, var context: Context): RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        var view = LayoutInflater.from(context).inflate(R.layout.project_card_recycle_view, parent,    false)
//        return MyViewHolder(view)
        var binding = ProjectCardRecycleViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.imageView.setImageResource(dataList.get(position).profile)
        holder.binding.projectNameView.setText(dataList.get(position).projectName)
        holder.binding.projectDescriptionView.setText((dataList.get(position)).projectDesc)
        holder.binding.techStackView.setText(dataList.get(position).techStack)
    }

    inner class MyViewHolder(var binding: ProjectCardRecycleViewBinding): RecyclerView.ViewHolder(binding.root){
    }
}