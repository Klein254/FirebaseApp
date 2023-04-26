package com.example.firebase_application_obiero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register_Activity : AppCompatActivity() {

    lateinit var EdtName:EditText
    lateinit var EdtEmail:EditText
    lateinit var EdtPassword:EditText
    lateinit var BtnCreate:Button

    //INITIALIZE FIREBASE
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        EdtName = findViewById(R.id.edtNameReg)
        EdtEmail = findViewById(R.id.edtEmailReg)
        EdtPassword = findViewById(R.id.edtPasswordReg)
        BtnCreate = findViewById(R.id.btnCreateReg)

        //INITIALIZE FIREBASE AGAIN
        auth = FirebaseAuth.getInstance()

        BtnCreate.setOnClickListener {
            var name = EdtName.text.toString().trim()
            var email = EdtEmail.text.toString().trim()
            var password = EdtPassword.text.toString().trim()

            //VALIDATE INPUTS
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the Fields is empty", Toast.LENGTH_SHORT).show()
            }
            else{
                //CREATE USER  IN FIREBASE
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Succesfully", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "Failed to Create User", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}