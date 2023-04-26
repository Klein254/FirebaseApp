package com.example.firebase_application_obiero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtnLogin:Button
    lateinit var BtnRegister:Button

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EdtEmail = findViewById(R.id.edtEmail)
        EdtPassword = findViewById(R.id.edtPassword)
        BtnLogin = findViewById(R.id.btnLogin)
        BtnRegister = findViewById(R.id.btnRegister)

        auth = FirebaseAuth.getInstance()


        BtnLogin.setOnClickListener {
            //
            var email = EdtEmail.text.toString().trim()
            var password = EdtPassword.text.toString().trim()

            //VALIDATE INPUT
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the inputs is Empty", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login SUCCESS", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Login FAILED", Toast.LENGTH_SHORT).show()
                    }

            }


            }
        }

        BtnRegister.setOnClickListener {

        }
    }
}