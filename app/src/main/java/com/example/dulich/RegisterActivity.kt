package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity :
    AppCompatActivity() {

    private lateinit var auth:
            FirebaseAuth

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        super.onCreate(
            savedInstanceState
        )

        setContentView(
            R.layout.activity_register
        )

        auth =
            FirebaseAuth.getInstance()

        val email =
            findViewById<EditText>(
                R.id.edtEmail
            )

        val pass =
            findViewById<EditText>(
                R.id.edtPass
            )

        val btnRegister =
            findViewById<Button>(
                R.id.btnRegister
            )
        val blockedAdminEmail = "admin@gmail.com"

        btnRegister.setOnClickListener {

            auth.createUserWithEmailAndPassword(

                email.text.toString(),

                pass.text.toString()

            )

                .addOnSuccessListener {

                    val user =
                        auth.currentUser

                    user
                        ?.sendEmailVerification()

                        ?.addOnCompleteListener {

                            if(
                                it.isSuccessful
                            ){

                                Toast.makeText(

                                    this,

                                    "Đã gửi mail xác thực",

                                    Toast.LENGTH_LONG

                                ).show()

                                startActivity(

                                    Intent(
                                        this,
                                        LoginActivity::class.java
                                    )

                                )

                                finish()

                            }

                            else{

                                Toast.makeText(

                                    this,

                                    "Lỗi gửi mail",

                                    Toast.LENGTH_LONG

                                ).show()

                            }

                        }

                }

                .addOnFailureListener {

                    Toast.makeText(

                        this,

                        "Lỗi: ${it.message}",

                        Toast.LENGTH_LONG

                    ).show()

                }

        }

    }

}