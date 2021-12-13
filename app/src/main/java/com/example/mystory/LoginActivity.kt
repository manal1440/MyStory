package com.example.mystory

import User
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
    }
    private fun connectView(){
        editTextUsername = findViewById(R.id.etUserId)
        editTextPassword = findViewById(R.id.etUserPass)
        buttonLogin =findViewById(R.id.loginButton)
        checkboxView = findViewById(R.id.checkbox1)
    }
    private fun login() {
        val arr:ArrayList<User> = ArrayList()
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
                    Toast.makeText(this,"Welcome ${user.email}",Toast.LENGTH_LONG).show()
                    break
                }else{
                    Toast.makeText(this,"Check your data",Toast.LENGTH_LONG).show()
                }
        }
        }
        buttonLogin?.setOnClickListener {
            if (editTextUsername?.text?.isEmpty() == true
                || editTextPassword?.text?.isEmpty() == true
                || checkboxView?.isChecked != true) {
                Toast.makeText(this, "Enter Your Data", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }
        }
    }
}