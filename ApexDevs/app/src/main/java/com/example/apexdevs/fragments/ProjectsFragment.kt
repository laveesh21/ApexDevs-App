package com.example.apexdevs.fragments

import SharedViewModel
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.apexdevs.R
import com.example.apexdevs.models.RecycleViewModel
import androidx.fragment.app.activityViewModels
import java.io.FileOutputStream
import java.io.ObjectOutputStream


class ProjectsFragment : Fragment() {

    private lateinit var capturedImage: ImageView
    private lateinit var projectNameEditText: EditText
    private lateinit var projectDescEditText: EditText
    private lateinit var techStackEditText: EditText
    private lateinit var uploadProjectButton: Button
    private val dataArrayList = ArrayList<RecycleViewModel>()
    private val sharedViewModel by activityViewModels<SharedViewModel>()
    private val dataArrayListFile = "projectsDetails.txt"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_projects, container, false)

        projectNameEditText = view.findViewById(R.id.editTextProjectName)
        projectDescEditText = view.findViewById(R.id.editTextProjectDescription)
        techStackEditText = view.findViewById(R.id.editTextTechStack)
        uploadProjectButton = view.findViewById(R.id.uploadProjectButtonView)

        dataArrayList.add (RecycleViewModel("Sample", "Sample", "Sample"))
        dataArrayList.add (RecycleViewModel("Sample", "Sample", "Sample"))

        sharedViewModel.dataArrayList.value = dataArrayList


//        sharedViewModel.dataArrayList.value = dataArrayList

        uploadProjectButton.setOnClickListener(){

            val projectName = projectNameEditText.text.toString()
            val projectDesc = projectDescEditText.text.toString()
            val techStack = techStackEditText.text.toString()

            if(!(projectDesc.isEmpty() || projectName.isEmpty() || techStack.isEmpty())){
                val newProject = RecycleViewModel( projectName, projectDesc, techStack)
                dataArrayList.add(newProject)
                sharedViewModel.dataArrayList.value = dataArrayList
                Toast.makeText(context, "Uploaded", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Fill Details", Toast.LENGTH_SHORT).show()
            }


            clearInputFields()
        }


        return view
    }

//    private fun writeDataToFile(data: ArrayList<RecycleViewModel>, fileName: String) {
//        try {
//            val outputStream: FileOutputStream? = activity?.openFileOutput(fileName, Context.MODE_PRIVATE)
//            val objectOutputStream = ObjectOutputStream(outputStream)
//            objectOutputStream.writeObject(data)
//            objectOutputStream.close()
//            outputStream?.close()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

    private fun clearInputFields() {
        projectNameEditText.text.clear()
        projectDescEditText.text.clear()
        techStackEditText.text.clear()
    }

}