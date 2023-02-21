package ru.samsung.itschool.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class BlankFragment6 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_blank, container, false)
        val btn4_back:Button = view.findViewById(R.id.ButtonBack)
        btn4_back.setOnClickListener{view.findNavController().popBackStack()}
        return view
    }

}