package com.example.quotesapp

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var ViewModelInstance:MainViewModel
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewModelInstance = ViewModelProvider(this,ViewModelFactory(application)).get(MainViewModel::class.java)
        setquotes(ViewModelInstance.getQuote()!!)

    }
    fun setquotes(quotes:Quotes)
    {
        binding.quoteText.text = quotes.quote
        binding.quoteAuthor.text = quotes.author_name
    }
    fun onPrevious(                                                               view: View) {
        setquotes(ViewModelInstance.previousQuote()!!)
    }
    fun onNext(view: View) {
        setquotes(ViewModelInstance.nextQuote()!!)
    }
    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,ViewModelInstance.getQuote()?.quote)
        startActivity(intent)
    }
}