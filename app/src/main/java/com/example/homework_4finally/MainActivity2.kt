package com.example.homework_4finally

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnCreateAccount.setOnClickListener(){
            if(txtName.text.trim().contentEquals("")
                ||txtLastName.text.trim().contentEquals("")
                ||txtEmail.text.trim().contentEquals("")
                ||txtPassword2.text.trim().contentEquals("")){
                Toast.makeText(this, "Please enter all the required data",
                    Toast.LENGTH_LONG).show()
            }// end of if
            else{
                //create user object
                val user=User(txtName.text.trim().toString(),
                    txtLastName.text.trim().toString(),
                    txtEmail.text.trim().toString(),
                    txtPassword2.text.trim().toString())
                //create an intent
                val reIntent=intent
                //put the user object
                reIntent.putExtra("user",user)
                //message an account created successfully
                Toast.makeText(this, "Account created successfully!",
                    Toast.LENGTH_LONG).show()
                setResult(Activity.RESULT_OK, reIntent)
                finish()
            }
        }
    }//end of onCreate function
}//end of class
