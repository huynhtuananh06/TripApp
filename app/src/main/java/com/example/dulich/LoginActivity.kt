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
import kotlin.jvm.java

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

                edtUser.text.toString().trim(),
                edtPass.text.toString().trim()

            ).addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val user = auth.currentUser
                    val email = user?.email

                    user?.reload()?.addOnCompleteListener {

                        // ADMIN
                        if (email == "admin@gmail.com") {

                            startActivity(
                                Intent(this, AdminActivity::class.java)
                            )
                            finish()

                        } else {

                            // USER
                            if (user?.isEmailVerified == true) {

                                startActivity(
                                    Intent(this, HomeActivity::class.java)
                                )
                                finish()

                            } else {

                                Toast.makeText(
                                    this,
                                    "Hãy xác thực Gmail trước",
                                    Toast.LENGTH_LONG
                                ).show()

                                auth.signOut()
                            }

                        }

                    }

                } else {

                    val message = task.exception?.message ?: ""

                    if (message.contains("user has been disabled", true)) {

                        Toast.makeText(
                            this,
                            "Tài khoản đã bị khóa.",
                            Toast.LENGTH_LONG
                        ).show()

                    } else {

                        Toast.makeText(
                            this,
                            "Sai email hoặc mật khẩu.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }

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