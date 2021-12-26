package com.example.mystory

import User
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var editTextUsername:EditText?=null
    private var editTextPassword:EditText?=null
    private var buttonLogin:Button?=null
    private var checkboxView:CheckBox?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        connectView()
        login()
        checkFields()
    }
    private fun connectView(){
        editTextUsername = findViewById(R.id.etUserId)
        editTextPassword = findViewById(R.id.etUserPass)
        buttonLogin =findViewById(R.id.loginButton)
        checkboxView = findViewById(R.id.checkbox1)
    }
    private fun login() {
        var arr:ArrayList<User> = ArrayList()
        arr.add(User("test@test.com","1234"))
        arr.add(User("test1@test.com","12345"))
        arr.add(User("test11@test.com","123456"))

        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()
            val user =User(username,password)

            for(userArray in arr){

                if(userArray.email == user.email
                    && userArray.password == user.password){
                        finish()
                   // Toast.makeText(this,"Welcome ${user.email}",Toast.LENGTH_LONG).show()
                    val i = Intent (this,MainActivity::class.java)
                    i.putExtra("email",userArray.email)
                    startActivity(i)
                    break
                }else{
                    Toast.makeText(this,"Check your data",Toast.LENGTH_LONG).show()
                }
        }
        }


    }
    private fun checkFields(){
        buttonLogin?.setOnClickListener {
            if (editTextUsername?.text?.isEmpty() == true) {
                editTextUsername?.error="Enter your email"

            }else if(editTextPassword?.text?.isEmpty()== true){
                editTextPassword?.error="Enter your password"
            }
        }
    }
}