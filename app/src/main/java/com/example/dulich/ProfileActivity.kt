package com.example.dulich

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var imgAvatar: ImageView
    private var avatarUri: Uri? = null

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->

            if (uri != null) {
                avatarUri = uri
                imgAvatar.setImageURI(uri)
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val user = auth.currentUser

        val txtName =
            findViewById<TextView>(
                R.id.txtName
            )

        val txtEmail =
            findViewById<TextView>(
                R.id.txtEmail
            )

        val btnLogout =
            findViewById<TextView>(
                R.id.btnLogout
            )
        imgAvatar = findViewById(R.id.imgAvatar)
        val btnEditAvatar =
            findViewById<ImageView>(R.id.btnEditAvatar)

        val btnAllOrders =
            findViewById<TextView>(
                R.id.btnAllOrders
            )


        // ===== USER INFO =====

        if (user != null) {

            txtEmail.text =
                user.email

            txtName.text =
                user.displayName
                    ?: "Người dùng"
        }

        // ===== TẤT CẢ ĐƠN HÀNG =====

        btnAllOrders.setOnClickListener {

            startActivity(

                Intent(
                    this,
                    OrderHotelActivity::class.java
                )

            )

        }

        // ===== ĐĂNG XUẤT =====

        btnLogout.setOnClickListener {

            auth.signOut()

            Toast.makeText(
                this,
                "Đã đăng xuất",
                Toast.LENGTH_SHORT
            ).show()

            val intent =
                Intent(
                    this,
                    LoginActivity::class.java
                )

            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)

            finish()

        }

        // ===== AVATAR =====

        btnEditAvatar.setOnClickListener {

            val items = arrayOf(
                "📷 Đổi ảnh đại diện",
                "🗑 Xóa ảnh đại diện",
                "❌ Đóng"
            )

            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Ảnh đại diện")
                .setItems(items) { dialog, which ->

                    when (which) {

                        // Chọn ảnh
                        0 -> {
                            pickImageLauncher.launch("image/*")
                        }

                        // Xóa ảnh
                        1 -> {

                            avatarUri = null

                            imgAvatar.setImageResource(R.drawable.ic_user)

                            Toast.makeText(
                                this,
                                "Đã xóa ảnh đại diện",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        // Đóng
                        2 -> dialog.dismiss()
                    }

                }
                .show()
        }
        val bottomNav =
            findViewById<BottomNavigationView>(
                R.id.bottomNav
            )
        bottomNav.selectedItemId =
            R.id.nav_profile

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> {

                    startActivity(
                        Intent(
                            this,
                            HomeActivity::class.java
                        )
                    )

                    finish() // tùy chọn

                    true
                }

                R.id.nav_suggest -> {

                    startActivity(
                        Intent(
                            this,
                            SuggestActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                R.id.nav_trip -> {

                    startActivity(
                        Intent(
                            this,
                            TripActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                R.id.nav_profile -> {

                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )

                    finish()

                    true
                }

                else -> false
            }

        }

    }

}