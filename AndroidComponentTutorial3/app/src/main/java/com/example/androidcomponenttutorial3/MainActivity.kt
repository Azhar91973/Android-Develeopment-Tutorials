package com.example.androidcomponenttutorial3

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponenttutorial3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var ViewModelInstance: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*

         here this parameter is the reference of this activity
         View Model are Life Cycle Aware SO it Will Behave According to this Activity(MainActivity)

         If the Configuration of the app changes then Oncreate Method call again and in this case ViewModelProvider check if the object
         is already exist then it will return that object it will not create a new object.and if not exist then it will create the object
         of the viewModel class

         */
        ViewModelInstance = ViewModelProvider(this, ViewModelFactory(5)).get(MainViewModel::class.java)
        setText()
    }

    // Button Listener
    fun increment(v: View) {
        // increment the count
        ViewModelInstance.increment()
        // set the new count
        setText()
    }

    fun setText() {
        // setting the new count
        binding.counterText.text = ViewModelInstance.count.toString()
    }
}