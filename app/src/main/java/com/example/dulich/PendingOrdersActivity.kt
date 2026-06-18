package com.example.dulich

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PendingOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_orders)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {

            finish()

        }

    }

}