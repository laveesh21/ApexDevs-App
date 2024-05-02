package com.example.apexdevs.models

import com.example.apexdevs.R

data class RecycleViewModel( var projectName: String, val projectDesc: String, val techStack: String) {
    val profile: Int = R.drawable.project_icon
}