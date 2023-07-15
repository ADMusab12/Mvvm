package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SumViewModel:ViewModel() {
    private val _value=MutableLiveData<Int>()
    val value:LiveData<Int> =_value

    fun sumNumbers(num1: Int, num2: Int) {
        val result = num1 + num2
        _value.value = result
    }
    fun subNumbers(num1: Int,num2: Int){
        val result=num1 - num2
        _value.value=result
    }
}
