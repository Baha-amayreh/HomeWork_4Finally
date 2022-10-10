package com.example.homework_4finally

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txtEmail

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var u1=User("Baha","Amayreh"
            ,"baha003@gmail.com","123")
        var u2=User("Mohammed","Amayreh"
            ,"amayreh@gmail.com","456")
        var u3=User("Yousef","Mohammed"
            ,"yousef@hotmail.com","789")
        var u4=User("Ali","Omer"
            ,"ali@miu.edu","321")
        var u5=User("Musa","Ahmed"
            ,"musa@miu.edu","654")
        var list= arrayListOf<User>(u1,u2,u3,u4,u5)
        btnform1.setOnClickListener(){
            var email=txtEmail.text.toString()
            var password=txtPassword.text.toString()
            var found=false;
            for(u in list){
                if(u.userName.equals(email)&&
                    u.password.equals(password)){
                    found=true
                    val form2= Intent(this,MyImages::class.java)
                    form2.putExtra("name",u.userName)
                    txtEmail.setText("")
                    txtPassword.setText("")
                    startActivity(form2)
                }//end of if
            }//end of for loop
            if(!found){
                Toast.makeText(this, "Wrong username or password!",
                    Toast.LENGTH_LONG).show()
            }
        }//end of btnform1
        var add = registerForActivityResult(
            ActivityResultContracts.
        StartActivityForResult()){ result->
            if(result.resultCode == Activity.RESULT_OK){
                val result1=result.data
                if(result1!=null){
                    val temp=result1.getSerializableExtra("user")
                    val u=temp as User
                    list.add(u)
                }
            }
        }//end of registerForActivityResult
        textView6.setOnClickListener(){
            val form3= Intent(this, MainActivity2::class.java)
            add.launch(form3)
        }
        fun find(ID:String):Int{
            for((index,data) in list.withIndex()){
                if(data.userName.equals(ID,true)){
                    return index
                }
            }
            return -1
        }//end of index fun

        textView4.setOnClickListener(){
            if(txtEmail.text.toString().
                trim().contentEquals("")){
                Toast.makeText(this,
                    "Please enter your email to retrieve your password",
                    Toast.LENGTH_LONG).show()
            }else{
                val index=find(txtEmail.text.trim().toString())
                if(index!=-1){
                    var address = list[index].userName
                    var password=list[index].password
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.setData(Uri.parse("mailto:"+address))
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, address)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Your password!");
                    intent.putExtra(Intent.EXTRA_TEXT, password)
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this, "you don't have an account! Create one and try again!",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }//end of fun onCreate
}// end of MainActivity class