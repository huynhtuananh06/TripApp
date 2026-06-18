package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        // CARD USERS
        val cardUsers = findViewById<CardView?>(R.id.cardUsers)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            val intent = Intent(this, LoginActivity::class.java)

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)

            finish()

        }

        cardUsers.setOnClickListener(View.OnClickListener { v: View? ->
            val intent = Intent(this@AdminActivity, UsersActivity::class.java)
            startActivity(intent)
        })
    }
}