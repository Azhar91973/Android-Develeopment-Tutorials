package com.example.androidcomponenttutorial3

import androidx.lifecycle.ViewModel

/*

* View Model Classes Are Independent From the Views
*
* */
class MainViewModel(val cntr:Int):ViewModel() {

    var count = cntr
    fun increment()
    {
        count++;
    }
}