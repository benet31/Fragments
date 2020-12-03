package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FullFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        save: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_full, container, false)
        if (arguments == null) return layout
        val user = arguments?.get("user") as User
        val nom = layout.findViewById<TextView>(R.id.nom)
        val prenom = layout.findViewById<TextView>(R.id.prenom)
        val age = layout.findViewById<TextView>(R.id.age)
        nom.text = user.nom
        prenom.text = user.prenom
        age.text = user.age.toString()
        return layout
    }






}