package com.example.firebase_application_obiero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtnLogin:Button
    lateinit var BtnRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EdtEmail = findViewById(R.id.edtEmail)
        EdtPassword = findViewById(R.id.edtPassword)
        BtnLogin = findViewById(R.id.btnLogin)
        BtnRegister = findViewById(R.id.btnRegister)


        BtnLogin.setOnClickListener {

        }

        BtnRegister.setOnClickListener {

        }
    }
}