package com.example.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val layout = inflater.inflate(R.layout.fragment_list, container, false)
        // Inflate the layout for this fragment
        val userlist = mutableListOf(
            User("Stark", "Catelun", 42),
            User("Lanister", "Tyrion", 49),
            User("Snow", "John", 32), User("Lanister", "Cercei", 34)
        )
        for (i in 4..100) userlist.add(User("nom$i", "prenom $i", i))
        val recycler = layout.findViewById<RecyclerView>(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        recycler.adapter = MyAdapter(userlist) { position ->
            // c'est ici que le click sera transmis au fragment
            // c'est ici que le click sera transmis au fragment
            val fullframe = requireActivity().findViewById<FrameLayout>(R.id.fullframe)
            val fullfragment = FullFragment()
            val args = Bundle()
            args.putSerializable("user", userlist[position])
            fullfragment.arguments = args
            if (fullframe != null) {
                fullframe.visibility = View.VISIBLE
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fullframe, fullfragment)
                    commit()
                }
            }
            else {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.root, fullfragment)
                    addToBackStack("full")
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    commit()
                }
            }
        }

        return layout
    }


}

