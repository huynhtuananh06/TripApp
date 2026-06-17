package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity :
    AppCompatActivity() {

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
            R.layout.activity_login
        )

        val btnLogin =
            findViewById<Button>(
                R.id.btnLogin
            )

        val edtUser =
            findViewById<EditText>(
                R.id.edtUser
            )

        val edtPass =
            findViewById<EditText>(
                R.id.edtPass
            )

        val txtRegister =
            findViewById<TextView>(
                R.id.txtRegister
            )

        val auth =
            FirebaseAuth.getInstance()


        btnLogin.setOnClickListener {

            auth.signInWithEmailAndPassword(

                edtUser.text.toString(),

                edtPass.text.toString()

            )

                .addOnSuccessListener {

                    val user =
                        auth.currentUser

                    user?.reload()

                    user?.reload()
                        ?.addOnCompleteListener {

                            if(
                                user?.isEmailVerified
                                == true
                            ){

                                startActivity(

                                    Intent(
                                        this,
                                        HomeActivity::class.java
                                    )

                                )

                                finish()

                            }

                            else{

                                Toast.makeText(

                                    this,

                                    "Hãy xác thực Gmail trước",

                                    Toast.LENGTH_LONG

                                ).show()

                            }

                        }

                }

                .addOnFailureListener {

                    Toast.makeText(

                        this,

                        "Sai email hoặc mật khẩu",

                        Toast.LENGTH_SHORT

                    ).show()

                }

        }

        txtRegister.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    RegisterActivity::class.java
                )

            )

        }

    }

}