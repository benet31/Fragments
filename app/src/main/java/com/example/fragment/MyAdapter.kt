package com.example.fragment

import android.graphics.Color
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.databinding.UserBinding


class MyAdapter(val users: List<User>, val callback: (Int) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //Un ViewHolder permet de stocker la vue de chaque item de la liste
    class MyViewHolder(
        val v: LinearLayout,
        val binding: UserBinding
    ) : RecyclerView.ViewHolder(v)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val binding = DataBindingUtil.inflate<UserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.user,
            parent,
            false
        )
        val layout = binding.root
        val holder = MyViewHolder(layout as LinearLayout, binding)
        layout.setOnClickListener {

            users[holder.adapterPosition].isSelected = true
            callback(holder.adapterPosition)

        }


        return holder
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val nom = holder.v.findViewById<TextView>(R.id.nom)
        val prenom = holder.v.findViewById<TextView>(R.id.prenom)
        val age = holder.v.findViewById<TextView>(R.id.age)

        //notifyItemChanged(position)
/*
        if (users[position].age > 40) {

            holder.v.setBackgroundColor(Color.GREEN)

        } else {

            holder.v.setBackgroundColor(Color.YELLOW)

        }

        nom.text=users[position].nom
        prenom.text = users[position].prenom
        age.text=users[position].age.toString()*/

        holder.binding.user = users[position]

        //   notifyItemChanged(position)


    }


}