package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

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

        cardUsers.setOnClickListener(View.OnClickListener { v: View? ->
            val intent = Intent(this@AdminActivity, UsersActivity::class.java)
            startActivity(intent)
        })
    }
}