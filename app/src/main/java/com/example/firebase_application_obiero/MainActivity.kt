package com.example.firebase_application_obiero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var edt_User_Input:EditText
    lateinit var btn_Save_Data:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_User_Input = findViewById(R.id.edt_Data)
        btn_Save_Data = findViewById(R.id.btn_Save)

        //initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference




        btn_Save_Data.setOnClickListener {
            var user_data = edt_User_Input.text.toString().trim()

            databaseRef.setValue(user_data)

        }

    }
}