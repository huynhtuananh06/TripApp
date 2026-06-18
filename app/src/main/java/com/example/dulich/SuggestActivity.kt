package com.example.dulich

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SuggestActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.parseColor("#4DA8FF")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest)

        val region = findViewById<Spinner>(R.id.spinnerRegion)
        val place = findViewById<Spinner>(R.id.spinnerPlace)
        val btn = findViewById<Button>(R.id.btnSuggest)

        val intro = findViewById<TextView>(R.id.txtIntro)

        val img1 = findViewById<ImageView>(R.id.img1)
        val name1 = findViewById<TextView>(R.id.name1)
        val des1 = findViewById<TextView>(R.id.des1)
        val price1 = findViewById<TextView>(R.id.price1)
        val buy1 = findViewById<Button>(R.id.buy1)

        val img2 = findViewById<ImageView>(R.id.img2)
        val name2 = findViewById<TextView>(R.id.name2)
        val des2 = findViewById<TextView>(R.id.des2)
        val price2 = findViewById<TextView>(R.id.price2)
        val buy2 = findViewById<Button>(R.id.buy2)

        val img3 = findViewById<ImageView>(R.id.img3)
        val name3 = findViewById<TextView>(R.id.name3)
        val des3 = findViewById<TextView>(R.id.des3)
        val price3 = findViewById<TextView>(R.id.price3)
        val buy3 = findViewById<Button>(R.id.buy3)

        val resultLayout = findViewById<LinearLayout>(R.id.resultLayout)

        // 🔥 1. Ẩn toàn bộ kết quả ban đầu
        resultLayout.visibility = View.GONE

        fun showAll() {
            resultLayout.visibility = View.VISIBLE
            intro.visibility = View.VISIBLE

            img1.visibility = View.VISIBLE
            name1.visibility = View.VISIBLE
            des1.visibility = View.VISIBLE
            price1.visibility = View.VISIBLE
            buy1.visibility = View.VISIBLE

            img2.visibility = View.VISIBLE
            name2.visibility = View.VISIBLE
            des2.visibility = View.VISIBLE
            price2.visibility = View.VISIBLE
            buy2.visibility = View.VISIBLE

            img3.visibility = View.VISIBLE
            name3.visibility = View.VISIBLE
            des3.visibility = View.VISIBLE
            price3.visibility = View.VISIBLE
            buy3.visibility = View.VISIBLE
        }


        val regionList = arrayOf("Miền Bắc", "Miền Trung", "Miền Nam")

        region.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            regionList
        )

        val map = mapOf( "Miền Bắc" to listOf( "Hà Nội", "Sa Pa", "Vịnh Hạ Long", "Ninh Bình", "Mộc Châu", "Đảo Cát Bà", "Mai Châu" ), "Miền Trung" to listOf( "Đà Nẵng", "Huế", "Hội An", "Nha Trang", "Đà Lạt", "Mũi Né", "Quy Nhơn", "Đảo Lý Sơn" ), "Miền Nam" to listOf( "Phú Quốc", "Vũng Tàu", "Cần Thơ", "TP Hồ Chí Minh", "Cà Mau", "Côn Đảo", "Châu Đốc" ) )

        region.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selected = regionList[position]
                place.adapter = ArrayAdapter(
                    this@SuggestActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    map[selected] ?: emptyList()
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn.setOnClickListener {

            if (place.selectedItem == null) return@setOnClickListener

            when (place.selectedItem.toString()) {

                "Đà Nẵng" -> {
                    showAll()

                    intro.text = "Đà Nẵng là thành phố du lịch nổi tiếng."

                    img1.setImageResource(R.drawable.caurong)
                    name1.text = "Cầu Rồng"
                    des1.text = "Cầu Rồng là biểu tượng nổi bật của thành phố Đà Nẵng, bắc qua sông Hàn với thiết kế hình rồng vàng độc đáo.\n" +
                            "Cây cầu có khả năng phun lửa và phun nước vào cuối tuần, thu hút rất nhiều du khách tham quan.\n" +
                            "Đây là địa điểm check-in nổi tiếng và là niềm tự hào của người dân Đà Nẵng."

                    img2.setImageResource(R.drawable.banahill)
                    name2.text = "Bà Nà Hills"
                    des2.text = "Bà Nà Hills là khu du lịch nổi tiếng nằm trên đỉnh núi thuộc Đà Nẵng, được mệnh danh là 'châu Âu thu nhỏ'.\n" +
                            "Nơi đây có Cầu Vàng nổi tiếng với bàn tay khổng lồ nâng đỡ, cùng khí hậu mát mẻ quanh năm.\n" +
                            "Du khách có thể trải nghiệm cáp treo dài nhất thế giới, khu làng Pháp và nhiều trò chơi giải trí hấp dẫn."

                    img3.setImageResource(R.drawable.sontra)
                    name3.text = "Bán đảo Sơn Trà"
                    des3.text = "Bán đảo Sơn Trà là khu bảo tồn thiên nhiên nổi tiếng của Đà Nẵng, được ví như lá phổi xanh của thành phố.\n" +
                            "Nơi đây có rừng nguyên sinh, đường ven biển tuyệt đẹp và chùa Linh Ứng với tượng Phật Bà cao nhất Việt Nam.\n" +
                            "Du khách có thể ngắm toàn cảnh Đà Nẵng từ trên cao và khám phá hệ sinh thái đa dạng."

                }
            }
        }
        val bottomNav =
            findViewById<BottomNavigationView>(
                R.id.bottomNav
            )
        bottomNav.selectedItemId =
            R.id.nav_suggest

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