    package com.example.dulich

    import android.graphics.Color
    import android.os.Bundle
    import androidx.appcompat.widget.SearchView
    import androidx.appcompat.app.AppCompatActivity
    import androidx.navigation.findNavController
    import androidx.navigation.ui.navigateUp
    import java.text.Normalizer
    import androidx.recyclerview.widget.RecyclerView
    import androidx.recyclerview.widget.GridLayoutManager
    import android.content.Intent
    import com.google.android.material.bottomnavigation.BottomNavigationView

    class HomeActivity : AppCompatActivity() {


        private lateinit var adapter: PlaceAdapter
        private lateinit var List: List<Place>

        override fun onCreate(
            savedInstanceState: Bundle?
        ) {

            super.onCreate(
                savedInstanceState
            )

            setContentView(
                R.layout.activity_home
            )
            val search =
                findViewById<SearchView>(
                    R.id.search
                )

            val recycler =
                findViewById<RecyclerView>(
                    R.id.recyclerPlace
                )
            window.statusBarColor = Color.parseColor("#4DA8FF")




            List = listOf(

                // MIỀN BẮC
                Place(
                    R.drawable.hanoi,
                    "Hà Nội",
                    "Hà Nội - Miền Bắc"
                ),

                Place(
                    R.drawable.sapa,
                    "Sa Pa",
                    "Lào Cai - Miền Bắc"
                ),

                Place(
                    R.drawable.halong,
                    "Vịnh Hạ Long",
                    "Quảng Ninh - Miền Bắc"
                ),

                Place(
                    R.drawable.ninhbinh,
                    "Ninh Bình",
                    "Ninh Bình - Miền Bắc"
                ),

                Place(
                    R.drawable.mocchau,
                    "Mộc Châu",
                    "Sơn La - Miền Bắc"
                ),

                Place(
                    R.drawable.catba,
                    "Đảo Cát Bà",
                    "Hải Phòng - Miền Bắc"
                ),

                Place(
                    R.drawable.maichau,
                    "Mai Châu",
                    "Hòa Bình - Miền Bắc"
                ),


// MIỀN TRUNG
                Place(
                    R.drawable.danang,
                    "Đà Nẵng",
                    "Đà Nẵng - Miền Trung"
                ),

                Place(
                    R.drawable.hue,
                    "Huế",
                    "Thừa Thiên Huế - Miền Trung"
                ),

                Place(
                    R.drawable.hoian,
                    "Hội An",
                    "Quảng Nam - Miền Trung"
                ),

                Place(
                    R.drawable.nhatrang,
                    "Nha Trang",
                    "Khánh Hòa - Miền Trung"
                ),

                Place(
                    R.drawable.dalat,
                    "Đà Lạt",
                    "Lâm Đồng - Miền Trung"
                ),

                Place(
                    R.drawable.muine,
                    "Mũi Né",
                    "Bình Thuận - Miền Trung"
                ),

                Place(
                    R.drawable.quynhon,
                    "Quy Nhơn",
                    "Bình Định - Miền Trung"
                ),
                Place(
                    R.drawable.lyson,
                    "Đảo Lý Sơn",
                    "Quảng Ngãi - Miền Trung"
                ),


// MIỀN NAM
                Place(
                    R.drawable.phuquoc,
                    "Phú Quốc",
                    "Kiên Giang - Miền Nam"
                ),

                Place(
                    R.drawable.vungtau,
                    "Vũng Tàu",
                    "Bà Rịa - Vũng Tàu - Miền Nam"
                ),

                Place(
                    R.drawable.cantho,
                    "Cần Thơ",
                    "Cần Thơ - Miền Nam"
                ),

                Place(
                    R.drawable.saigon,
                    "TP Hồ Chí Minh",
                    "TP Hồ Chí Minh - Miền Nam"
                ),

                Place(
                    R.drawable.camau,
                    "Cà Mau",
                    "Cà Mau - Miền Nam"
                ),

                Place(
                    R.drawable.condao,
                    "Côn Đảo",
                    "Bà Rịa - Vũng Tàu - Miền Nam"
                ),

                Place(
                    R.drawable.chaudoc,
                    "Châu Đốc",
                    "An Giang - Miền Nam"
                ),

            )

            recycler.layoutManager =
                GridLayoutManager(
                    this,
                    2
                )

            adapter =
                PlaceAdapter(List)
            recycler.adapter =
                adapter




            search.isIconified = false

            search.clearFocus()

            search.setOnClickListener {

                search.isIconified = false

            }
            search.setOnQueryTextListener(

                object :
                    SearchView.OnQueryTextListener {

                    override fun onQueryTextSubmit(
                        query: String?
                    ): Boolean {

                        filterPlace(
                            query ?: ""
                        )

                        return true
                    }

                    override fun onQueryTextChange(
                        newText: String?
                    ): Boolean {

                        filterPlace(
                            newText ?: ""
                        )

                        return true

                    }

                }

            )
            val bottomNav =
                findViewById<BottomNavigationView>(
                    R.id.bottomNav
                )

            bottomNav.setOnItemSelectedListener {

                when(it.itemId){

                    R.id.nav_home -> true

                    R.id.nav_suggest -> {

                        startActivity(
                            Intent(
                                this,
                                SuggestActivity::class.java
                            )
                        )

                        true
                    }

                    R.id.nav_trip -> {

                        startActivity(
                            Intent(
                                this,
                                TripActivity::class.java
                            )
                        )

                        true
                    }

                    R.id.nav_profile -> {

                        startActivity(
                            Intent(
                                this,
                                ProfileActivity::class.java
                            )
                        )

                        true
                    }

                    else -> false
                }

            }


        }

        private fun filterPlace(
            text: String
        ){

            val keyword =
                removeAccent(
                    text.lowercase()
                )

            val filteredList =
                List.filter {

                    removeAccent(
                        it.name.lowercase()
                    ).contains(
                        keyword
                    )

                }

            adapter.updateList(
                filteredList
            )

        }
        private fun removeAccent(
            text: String
        ): String {

            return Normalizer.normalize(
                text,
                Normalizer.Form.NFD
            )
                .replace(
                    "\\p{InCombiningDiacriticalMarks}+".toRegex(),
                    ""
                )
                .replace(
                    "đ",
                    "d"
                )
                .replace(
                    "Đ",
                    "D"
                )

        }


        override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.nav_host_fragment_content_home)
            val appBarConfiguration = null
            return navController.navigateUp(appBarConfiguration)
                    || super.onSupportNavigateUp()
        }


    }



