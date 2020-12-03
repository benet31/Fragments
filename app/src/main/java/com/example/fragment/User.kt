package com.example.fragment

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import java.io.Serializable

class User(var nom:String, var prenom: String, var age: Int): BaseObservable(), Serializable {

    @get: Bindable
    var isSelected: Boolean = false
    set(value)
    {
        field=value
        notifyPropertyChanged(BR.selected)

    }


}