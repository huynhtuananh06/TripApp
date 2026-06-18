package com.example.dulich

object HotelRepository {

    val hotels = listOf(

        Hotel(

            name = "Mercure Danang French Village Bana Hills",

            image = R.drawable.bana1,

            price = 1200000,

            rating = "4.8",

            address = "An Sơn, Hòa Ninh, Hòa Vang, Đà Nẵng",

            description =
                "Mercure Danang French Village Bana Hills là khách sạn 4 sao nằm ngay trên đỉnh Bà Nà Hills. Khách sạn mang phong cách kiến trúc Pháp cổ điển với khí hậu mát mẻ quanh năm. Đây là nơi nghỉ dưỡng lý tưởng dành cho du khách muốn khám phá Cầu Vàng và khu du lịch Bà Nà.",

            score = "9.2/10",

            review = "1.258 đánh giá",

            near1 = "Cầu Vàng - 300m",

            near2 = "Làng Pháp - 100m",

            near3 = "Fantasy Park - 250m",

            facility1 = "Wifi miễn phí",

            facility2 = "Hồ bơi",

            facility3 = "Bãi đỗ xe"

        ),
        Hotel(
            name = "Debay Hotel",
            image = R.drawable.bana2,
            price = 700000,
            rating = "4.5",
            address = "Bà Nà Hills, Hòa Vang, Đà Nẵng",
            description = "Debay Hotel là khách sạn mang phong cách kiến trúc Pháp nằm trong khu du lịch Bà Nà Hills. Khách sạn có không gian yên tĩnh, khí hậu mát mẻ quanh năm và thuận tiện để khám phá các điểm tham quan nổi tiếng trên đỉnh Bà Nà.",
            score = "8.8/10",
            review = "846 đánh giá",
            near1 = "Cầu Vàng - 500m",
            near2 = "Fantasy Park - 150m",
            near3 = "Làng Pháp - 300m",
            facility1 = "Wifi miễn phí",
            facility2 = "Nhà hàng",
            facility3 = "Lễ tân 24/7"
        ),

        Hotel(
            name = "Morin Hotel Ba Na Hills",
            image = R.drawable.bana3,
            price = 1700000,
            rating = "4.5",
            address = "Bà Nà Hills, Hòa Vang, Đà Nẵng",
            description = "Morin Hotel Ba Na Hills sở hữu phong cách cổ điển sang trọng với tầm nhìn đẹp ra toàn khu du lịch. Đây là lựa chọn lý tưởng cho du khách muốn nghỉ dưỡng và tận hưởng không khí mát lạnh trên núi.",
            score = "9.0/10",
            review = "932 đánh giá",
            near1 = "Cầu Vàng - 350m",
            near2 = "Làng Pháp - 80m",
            near3 = "Quảng trường Nhật Thực - 250m",
            facility1 = "Wifi miễn phí",
            facility2 = "Buffet sáng",
            facility3 = "Quầy bar"
        ),

        Hotel(
            name = "Vanda Hotel",
            image = R.drawable.rong1,
            price = 1100000,
            rating = "4.7",
            address = "03 Nguyễn Văn Linh, Hải Châu, Đà Nẵng",
            description = "Vanda Hotel là khách sạn 4 sao nằm ngay trung tâm thành phố Đà Nẵng, chỉ vài phút đi bộ đến Cầu Rồng. Khách sạn có hồ bơi trong nhà, spa và nhà hàng sang trọng.",
            score = "9.1/10",
            review = "1.625 đánh giá",
            near1 = "Cầu Rồng - 150m",
            near2 = "Sông Hàn - 200m",
            near3 = "Chợ Hàn - 1km",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Spa"
        ),

        Hotel(
            name = "HAIAN Riverfront Hotel",
            image = R.drawable.rong2,
            price = 1300000,
            rating = "4.6",
            address = "182 Bạch Đằng, Hải Châu, Đà Nẵng",
            description = "HAIAN Riverfront Hotel nằm bên bờ sông Hàn với tầm nhìn hướng Cầu Rồng tuyệt đẹp. Khách sạn nổi bật với phòng nghỉ hiện đại và dịch vụ chuyên nghiệp.",
            score = "9.0/10",
            review = "1.104 đánh giá",
            near1 = "Cầu Rồng - 250m",
            near2 = "Chợ Hàn - 500m",
            near3 = "Nhà thờ Con Gà - 650m",
            facility1 = "Wifi miễn phí",
            facility2 = "Nhà hàng",
            facility3 = "Phòng gym"
        ),

        Hotel(
            name = "Mitisa Hotel Da Nang",
            image = R.drawable.rong3,
            price = 900000,
            rating = "4.5",
            address = "67-69 Nguyễn Văn Linh, Hải Châu, Đà Nẵng",
            description = "Mitisa Hotel là khách sạn hiện đại với vị trí thuận tiện gần sân bay và Cầu Rồng. Phòng nghỉ rộng rãi, sạch sẽ và phù hợp cho cả khách du lịch lẫn công tác.",
            score = "8.9/10",
            review = "785 đánh giá",
            near1 = "Cầu Rồng - 400m",
            near2 = "Sân bay Đà Nẵng - 2km",
            near3 = "Bảo tàng Chăm - 700m",
            facility1 = "Wifi miễn phí",
            facility2 = "Bãi đỗ xe",
            facility3 = "Lễ tân 24/7"
        ),

        Hotel(
            name = "InterContinental Danang Sun Peninsula Resort",
            image = R.drawable.sontra1,
            price = 8500000,
            rating = "4.9",
            address = "Bãi Bắc, Bán đảo Sơn Trà, Đà Nẵng",
            description = "InterContinental Danang Sun Peninsula Resort là khu nghỉ dưỡng 5 sao đẳng cấp quốc tế nằm trên bán đảo Sơn Trà. Resort nổi tiếng với bãi biển riêng, kiến trúc độc đáo và dịch vụ sang trọng.",
            score = "9.7/10",
            review = "2.438 đánh giá",
            near1 = "Bãi Bắc - 100m",
            near2 = "Chùa Linh Ứng - 5km",
            near3 = "Đỉnh Bàn Cờ - 8km",
            facility1 = "Bãi biển riêng",
            facility2 = "Spa cao cấp",
            facility3 = "Hồ bơi vô cực"
        ),

        Hotel(
            name = "A La Carte Da Nang Beach",
            image = R.drawable.sontra2,
            price = 1500000,
            rating = "4.6",
            address = "200 Võ Nguyên Giáp, Sơn Trà, Đà Nẵng",
            description = "A La Carte Da Nang Beach là khách sạn cao cấp nằm sát bãi biển Mỹ Khê. Khách sạn nổi tiếng với hồ bơi vô cực trên tầng thượng và tầm nhìn hướng biển tuyệt đẹp.",
            score = "9.2/10",
            review = "1.936 đánh giá",
            near1 = "Biển Mỹ Khê - 50m",
            near2 = "Bán đảo Sơn Trà - 4km",
            near3 = "Cầu Rồng - 2km",
            facility1 = "Hồ bơi vô cực",
            facility2 = "Wifi miễn phí",
            facility3 = "Phòng gym"
        ),

        Hotel(
            name = "Son Tra Resort & Spa",
            image = R.drawable.sontra3,
            price = 1200000,
            rating = "4.4",
            address = "Bãi Nam, Sơn Trà, Đà Nẵng",
            description = "Son Tra Resort & Spa là khu nghỉ dưỡng ven biển với không gian xanh, yên tĩnh và thích hợp cho kỳ nghỉ dưỡng gia đình. Resort có hồ bơi ngoài trời và bãi biển riêng.",
            score = "8.8/10",
            review = "692 đánh giá",
            near1 = "Bãi Nam - 80m",
            near2 = "Chùa Linh Ứng - 3km",
            near3 = "Đỉnh Bàn Cờ - 6km",
            facility1 = "Bãi biển riêng",
            facility2 = "Hồ bơi",
            facility3 = "Nhà hàng"
        ),
        Hotel(
            name = "Apricot Hotel",
            image = R.drawable.hoguom1,
            price = 3200000,
            rating = "4.8",
            address = "136 Hàng Trống, Hoàn Kiếm, Hà Nội",
            description = "Apricot Hotel là khách sạn 5 sao sang trọng nằm ngay bên Hồ Hoàn Kiếm với tầm nhìn tuyệt đẹp và thiết kế mang đậm phong cách nghệ thuật.",
            score = "9.4/10",
            review = "1.863 đánh giá",
            near1 = "Hồ Hoàn Kiếm - 50m",
            near2 = "Đền Ngọc Sơn - 300m",
            near3 = "Nhà hát Lớn - 700m",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Spa"
        ),

        Hotel(
            name = "Hanoi Pearl Hotel",
            image = R.drawable.hoguom2,
            price = 1800000,
            rating = "4.5",
            address = "06 Bảo Khánh, Hoàn Kiếm, Hà Nội",
            description = "Khách sạn nằm giữa khu phố cổ Hà Nội, chỉ vài phút đi bộ đến Hồ Hoàn Kiếm và nhiều địa điểm du lịch nổi tiếng.",
            score = "9.0/10",
            review = "1.225 đánh giá",
            near1 = "Hồ Hoàn Kiếm - 200m",
            near2 = "Phố cổ - 400m",
            near3 = "Chợ Đồng Xuân - 1km",
            facility1 = "Wifi miễn phí",
            facility2 = "Nhà hàng",
            facility3 = "Phòng gym"
        ),

        Hotel(
            name = "The Oriental Jade Hotel",
            image = R.drawable.hoguom3,
            price = 3500000,
            rating = "4.9",
            address = "92-94 Hàng Trống, Hoàn Kiếm, Hà Nội",
            description = "Khách sạn 5 sao hiện đại với hồ bơi vô cực trên tầng thượng và tầm nhìn toàn cảnh Hồ Hoàn Kiếm.",
            score = "9.6/10",
            review = "2.150 đánh giá",
            near1 = "Hồ Hoàn Kiếm - 150m",
            near2 = "Nhà thờ Lớn - 250m",
            near3 = "Phố cổ - 500m",
            facility1 = "Hồ bơi vô cực",
            facility2 = "Spa",
            facility3 = "Wifi miễn phí"
        ),

        Hotel(
            name = "La Siesta Classic Ma May",
            image = R.drawable.phoco1,
            price = 2600000,
            rating = "4.8",
            address = "94 Mã Mây, Hoàn Kiếm, Hà Nội",
            description = "Khách sạn boutique nổi tiếng giữa khu phố cổ với phong cách sang trọng và dịch vụ đạt chuẩn quốc tế.",
            score = "9.5/10",
            review = "1.950 đánh giá",
            near1 = "Phố cổ - 50m",
            near2 = "Chợ đêm - 300m",
            near3 = "Hồ Hoàn Kiếm - 600m",
            facility1 = "Wifi miễn phí",
            facility2 = "Spa",
            facility3 = "Nhà hàng"
        ),

        Hotel(
            name = "Hanoi Old Quarter Hotel",
            image = R.drawable.phoco2,
            price = 1200000,
            rating = "4.4",
            address = "02 Nguyễn Hữu Huân, Hoàn Kiếm, Hà Nội",
            description = "Khách sạn giá tốt nằm ngay khu phố cổ, thuận tiện khám phá văn hóa và ẩm thực Hà Nội.",
            score = "8.8/10",
            review = "935 đánh giá",
            near1 = "Phố cổ - 100m",
            near2 = "Hồ Hoàn Kiếm - 500m",
            near3 = "Chợ Đồng Xuân - 600m",
            facility1 = "Wifi miễn phí",
            facility2 = "Lễ tân 24/7",
            facility3 = "Đưa đón sân bay"
        ),

        Hotel(
            name = "May De Ville Hotel",
            image = R.drawable.phoco3,
            price = 2000000,
            rating = "4.6",
            address = "43 Gia Ngư, Hoàn Kiếm, Hà Nội",
            description = "Khách sạn hiện đại với hồ bơi trên tầng thượng, phù hợp cho kỳ nghỉ tại trung tâm Hà Nội.",
            score = "9.1/10",
            review = "1.300 đánh giá",
            near1 = "Phố cổ - 150m",
            near2 = "Hồ Hoàn Kiếm - 400m",
            near3 = "Đền Ngọc Sơn - 450m",
            facility1 = "Hồ bơi",
            facility2 = "Wifi miễn phí",
            facility3 = "Nhà hàng"
        ),

        Hotel(
            name = "The Ann Hanoi Hotel",
            image = R.drawable.vanmieu1,
            price = 2800000,
            rating = "4.7",
            address = "38A Hàng Chuối, Hai Bà Trưng, Hà Nội",
            description = "Khách sạn cao cấp với không gian yên tĩnh, thuận tiện di chuyển đến Văn Miếu và khu trung tâm.",
            score = "9.2/10",
            review = "1.180 đánh giá",
            near1 = "Văn Miếu - 2km",
            near2 = "Hồ Hoàn Kiếm - 2km",
            near3 = "Ga Hà Nội - 1.5km",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Phòng gym"
        ),

        Hotel(
            name = "Hanoi Emotion Hotel",
            image = R.drawable.vanmieu2,
            price = 1000000,
            rating = "4.3",
            address = "26-28 Tôn Đức Thắng, Đống Đa, Hà Nội",
            description = "Khách sạn 3 sao gần Văn Miếu với giá hợp lý và dịch vụ thân thiện.",
            score = "8.6/10",
            review = "780 đánh giá",
            near1 = "Văn Miếu - 300m",
            near2 = "Ga Hà Nội - 800m",
            near3 = "Lăng Bác - 2km",
            facility1 = "Wifi miễn phí",
            facility2 = "Nhà hàng",
            facility3 = "Đưa đón sân bay"
        ),

        Hotel(
            name = "Pullman Hanoi",
            image = R.drawable.vanmieu3,
            price = 2900000,
            rating = "4.6",
            address = "40 Cát Linh, Đống Đa, Hà Nội",
            description = "Khách sạn 5 sao hiện đại gần Văn Miếu với đầy đủ tiện nghi cao cấp.",
            score = "9.1/10",
            review = "1.420 đánh giá",
            near1 = "Văn Miếu - 700m",
            near2 = "Lăng Bác - 1.8km",
            near3 = "Ga Hà Nội - 1km",
            facility1 = "Hồ bơi",
            facility2 = "Spa",
            facility3 = "Wifi miễn phí"
        ),

        Hotel(
            name = "Premier Village Phu Quoc Resort",
            image = R.drawable.baisa1,
            price = 6500000,
            rating = "4.8",
            address = "Mũi Ông Đội, An Thới, Phú Quốc",
            description = "Resort 5 sao sang trọng với biệt thự hồ bơi riêng và bãi biển tuyệt đẹp.",
            score = "9.7/10",
            review = "2.320 đánh giá",
            near1 = "Bãi Sao - 3km",
            near2 = "Cáp treo Hòn Thơm - 5km",
            near3 = "Sunset Town - 6km",
            facility1 = "Bãi biển riêng",
            facility2 = "Spa",
            facility3 = "Hồ bơi vô cực"
        ),

        Hotel(
            name = "JW Marriott Phu Quoc Emerald Bay",
            image = R.drawable.baisa2,
            price = 8000000,
            rating = "4.9",
            address = "Bãi Khem, An Thới, Phú Quốc",
            description = "Một trong những khu nghỉ dưỡng sang trọng nhất Việt Nam với kiến trúc độc đáo và dịch vụ đẳng cấp.",
            score = "9.9/10",
            review = "3.015 đánh giá",
            near1 = "Bãi Khem - 50m",
            near2 = "Bãi Sao - 2km",
            near3 = "Sunset Town - 5km",
            facility1 = "Spa",
            facility2 = "Hồ bơi",
            facility3 = "Bãi biển riêng"
        ),

        Hotel(
            name = "Ancarine Beach Resort",
            image = R.drawable.baisa3,
            price = 2500000,
            rating = "4.5",
            address = "Cửa Dương, Phú Quốc",
            description = "Resort yên tĩnh với khuôn viên xanh mát, thích hợp nghỉ dưỡng cùng gia đình.",
            score = "9.0/10",
            review = "950 đánh giá",
            near1 = "Biển - 50m",
            near2 = "Chợ đêm Phú Quốc - 8km",
            near3 = "VinWonders - 18km",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Nhà hàng"
        ),

        Hotel(
            name = "Vinholidays Fiesta Phú Quốc",
            image = R.drawable.grandworld1,
            price = 1200000,
            rating = "4.6",
            address = "Grand World, Gành Dầu, Phú Quốc",
            description = "Khách sạn hiện đại ngay trong khu Grand World, thuận tiện vui chơi và mua sắm.",
            score = "9.2/10",
            review = "1.340 đánh giá",
            near1 = "Grand World - 100m",
            near2 = "VinWonders - 1km",
            near3 = "Safari - 2km",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Nhà hàng"
        ),

        Hotel(
            name = "Solea Hotel Grand World",
            image = R.drawable.grandworld2,
            price = 900000,
            rating = "4.5",
            address = "Grand World, Gành Dầu, Phú Quốc",
            description = "Khách sạn có thiết kế hiện đại, phù hợp với du khách muốn khám phá Grand World.",
            score = "8.9/10",
            review = "860 đánh giá",
            near1 = "Grand World - 50m",
            near2 = "VinWonders - 900m",
            near3 = "Safari - 2km",
            facility1 = "Wifi miễn phí",
            facility2 = "Bãi đỗ xe",
            facility3 = "Lễ tân 24/7"
        ),

        Hotel(
            name = "Vinpearl Wonderworld Phú Quốc",
            image = R.drawable.grandworld3,
            price = 3500000,
            rating = "4.8",
            address = "Gành Dầu, Phú Quốc",
            description = "Khu nghỉ dưỡng biệt thự cao cấp với không gian riêng tư và nhiều tiện ích.",
            score = "9.5/10",
            review = "2.250 đánh giá",
            near1 = "Grand World - 1km",
            near2 = "VinWonders - 800m",
            near3 = "Safari - 2km",
            facility1 = "Biệt thự hồ bơi",
            facility2 = "Spa",
            facility3 = "Nhà hàng"
        ),

        Hotel(
            name = "Vinpearl Resort & Spa Phú Quốc",
            image = R.drawable.vinwonders1,
            price = 3200000,
            rating = "4.7",
            address = "Gành Dầu, Phú Quốc",
            description = "Resort cao cấp sát VinWonders với bãi biển riêng và dịch vụ nghỉ dưỡng hoàn hảo.",
            score = "9.4/10",
            review = "2.420 đánh giá",
            near1 = "VinWonders - 200m",
            near2 = "Safari - 1km",
            near3 = "Grand World - 1.5km",
            facility1 = "Bãi biển riêng",
            facility2 = "Spa",
            facility3 = "Hồ bơi"
        ),

        Hotel(
            name = "Radisson Blu Resort Phú Quốc",
            image = R.drawable.vinwonders2,
            price = 2800000,
            rating = "4.6",
            address = "Bãi Dài, Gành Dầu, Phú Quốc",
            description = "Khách sạn 5 sao hiện đại gần VinWonders với nhiều tiện ích giải trí.",
            score = "9.2/10",
            review = "1.610 đánh giá",
            near1 = "VinWonders - 500m",
            near2 = "Safari - 1km",
            near3 = "Grand World - 700m",
            facility1 = "Wifi miễn phí",
            facility2 = "Casino",
            facility3 = "Hồ bơi"
        ),

        Hotel(
            name = "Wyndham Grand Phú Quốc",
            image = R.drawable.vinwonders3,
            price = 2500000,
            rating = "4.5",
            address = "Bãi Dài, Gành Dầu, Phú Quốc",
            description = "Khách sạn sang trọng với vị trí lý tưởng để khám phá VinWonders và Grand World.",
            score = "9.1/10",
            review = "1.530 đánh giá",
            near1 = "VinWonders - 300m",
            near2 = "Grand World - 800m",
            near3 = "Safari - 1km",
            facility1 = "Wifi miễn phí",
            facility2 = "Hồ bơi",
            facility3 = "Nhà hàng"
        )

    )
    fun getHotel(name: String): Hotel? {

        return hotels.find {

            it.name == name

        }

    }

}