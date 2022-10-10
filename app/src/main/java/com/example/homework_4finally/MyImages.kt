package com.example.homework_4finally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_images.*

class MyImages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_images)
        val intent=intent
        val name=intent.getStringExtra("name")
        if(name!=null){
            txtViewMessage1.text=name.toString()
        }
        imageView3.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Electronic category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView4.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView5.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView6.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }
    }
}