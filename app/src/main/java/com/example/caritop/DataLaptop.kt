package com.example.caritop

import android.graphics.ColorSpace

class DataLaptop {
    private val merkLaptop = arrayListOf("ASUS",
    "ASUS",
    "Lenovo",
    "Lenovo",
    "MSI",
    "MSI",
    "ASUS",
    "Lenovo",
    "Dell",
    "Dell",
    "Apple",
    "Apple")

    private val namaLaptop = arrayListOf("ASUS TUF Gaming FX505",
    "ASUS ROG Zephyrus G14",
    "Lenovo Legion 5 15",
    "Lenovo IdeaPad L340 Gaming",
    "MSI GT76 Titan 9SF",
    "MSI GL63 8RD",
    "ASUS ZenBook S13 UX392FN",
    "Lenovo Thinkbook 14 G2",
    "Dell Inspiron 14-3467",
    "Dell Alienware 17",
    "Apple Macbook Air 2020",
    "Apple Macbook Air M1")

    private val descLaptop = arrayListOf("Menyatukan prosesor AMD Ryzen™ terbaru dan grafis NVIDIA GeForce GTX™ pada layar NanoEdge IPS-level hingga 144Hz dengan ASUS TUF Gaming FX505 baru, yang menghadirkan perangkat gaming berkinerja tinggi dan imersif dengan harga terjangkau. Telah diuji dan disertifikasi untuk memenuhi standar MIL-STD-810G kelas militer, memastikan ketangguhan dan daya tahan yang Anda butuhkan untuk menahan benturan dan guncangan dalam kehidupan sehari-hari.",
    "Ditata dalam Eclipse Grey metalik atau Moonlight White pearlescent, Zephyrus G14 sangat memukau. Estetikanya yang bersih berpindah dengan mudah dari pesta LAN ke ruang kuliah, dengan detail yang disempurnakan yang menempatkannya di kelasnya sendiri. Penggilingan CNC presisi menciptakan 6.536 perforasi di seluruh tutup aluminium untuk desain dot matrix yang khas. Penguatan sarang lebah menambah kekuatan dengan material minimal untuk menjaga sasis tetap ringan. Dek paduan magnesium-aluminium tahan sidik jari agar tetap terlihat segar setiap hari.",
    "Menawarkan pilihan performa untuk setiap gamers dengan desain laptop yang minimalis, Legion 5 15 menggabungkan konfigurasi prosesor AMD Ryzen 4000 series, grafis NVIDIA®GeForce®dan pilihan hard drive SSD, yang telah dilengkapi dengan sistem termal via Legion Coldfront 2.0. Nikmati refresh rates yang sangat cepat dengan 100% FHD color accurate display dan kontrol yang cepat mengunakan TrueStrike keyboard untuk mengalahkan lawan Anda.",
    "Gaming adalah tentang membuat pilihan yang tepat. Dengan IdeaPad L340 Gaming (15), Anda telah melakukan pemilihan yang hebat sejak awal. Dilengkapi dengan prosesor Intel Core i7 terbaru, NVIDIA GeForce generasi terbaru dan Dolby Audio yang memukau; Anda akan merasakan kekuatan nyata dan kinerja tanpa batas secara langsung. Anda juga akan lebih dari siap untuk siapa saja, apa saja, kapan saja.",
    "GT76 yang baru adalah Titan ter-ekstrem yang pernah diciptakan. Desain luarnya yang terinspirasi dari mobil balap eksotis,dengan lapisan aluminium aerodinamis yang ramping dan bodywork bertemakan serat karbon.Jeruji dan metal yang dikombinasikan memberikan kontribusi asupan dan pembuangan yang maksimum untuk tenaga super.",
    "MSI GL63 memiliki bodi yang dapat kami bilang sama persis dengan GL62, bahan dope dari bagian cover hingga area palm rest. Pada bagian cover terdapat sebuah logo MSI yang sederhana dan tidak ada lampu LED apapun, lalu terdapat sisa engrave dua buah garis disamping logo, dengan ini kami menebak bahwa GL63 menggunakan casing MSI seri GE. Bertemakan warna hitam merah yang terasa simple, tapi dengan keserdehanaan ini membuat notebook ini terasa “gahar”.",
    "ASUS ZenBook S13 UX392FN layar NanoEdge 13.9, dukungan grafis NVIDIA MX150, berat ultra ringan 1,1 kg, ultra tipis 12,9 mm, engsel ErgoLift untuk kenyamanan mengetik",
    "Lenovo ThinkBook 14 Gen 2 adalah laptop 14 inci dengan tenaga kencang. Di dalam laptop ini ada prosesor AMD Ryzen 4000 Series. Anda bisa menangani data besar dan membuat dokumen kompleks dengan mudah. Prosesor ini memungkinkan Anda bisa bekerja lebih cepat dan lebih banyak.",
    "6th Generation Intel Core i3-6006U Processor (3M Cache, 2.00 GHz) / 4GB / 500GB / AMD Radeon R5 M430 Graphics with 2GB DDR3 / 14.0-inch HD (1366 x 768) Anti-Glare LED-Backlit Display / Windows 10",
    "Mainkan seperti yang Anda inginkan di Alienware 17. Lebih tipis dan lebih ringan daripada laptop 17\" mana pun yang pernah kami buat sebelumnya, tetapi itu tidak berarti kami berhemat pada kinerja. Dibuat dengan permukaan yang diisi serat karbon yang terinspirasi dari ruang angkasa yang menambah kekakuan dan daya tahan , heat sink tembaga yang memungkinkan pendinginan yang tepat dan CPU serta grafis berperforma tinggi",
    "MacBook Air yang luar biasa tipis dan ringan kini lebih canggih dibanding sebelumnya. Hadir dengan layar Retina yang brilian, Magic Keyboard baru, Touch ID, prosesor dengan performa hingga dua kali lipat, grafis lebih cepat, dan kapasitas penyimpanan dua kali lebih besar. Desain lekukan ramping dengan rangka yang terbuat dari 100 persen aluminium hasil daur ulang, menjadikannya Mac paling ramah lingkungan. Dan dengan kekuatan baterai sepanjang hari, Mac paling populer kami adalah laptop Anda yang paling portabel dan serbaguna.",
    "Laptop Apple yang paling tipis dan ringan, bertenaga super dengan chip Apple M1. Tuntaskan berbagai proyek Anda dengan CPU 8-core super cepat. Tingkatkan aplikasi dan game kaya grafis ke level lebih tinggi dengan GPU hingga 8-core. Dan percepat tugas pembelajaran mesin dengan Neural Engine 16-core. "
    )

    private val photoLaptop = arrayListOf(R.drawable.tuf_505,
    R.drawable.zephyrus,
    R.drawable.legion,
    R.drawable.ideapad,
    R.drawable.msi_titan,
    R.drawable.msi_gl63,
    R.drawable.zenbook,
    R.drawable.thinkbook,
    R.drawable.dell_inspiron,
    R.drawable.dell_alienware,
    R.drawable.macbook_air_2020,
    R.drawable.macbook_air_m1)


    private val hargaLaptop = arrayListOf("Rp 13.299.000",
    "Rp 15.629.000",
    "Rp 13.799.000",
    "Rp 6.160.000",
    "Rp 70,999,000",
    "Rp 15.999.000",
    "Rp 17.549.000",
    "Rp 8.950.000",
    "Rp 5.399.000",
    "Rp 22.000.000",
    "Rp 14.999.000",
    "Rp 16.499.000")

    private val namaPenjualLaptop = arrayListOf("Sam Rudy",
    "Bella Shakir",
    "Joko Siswanto",
    "Gisella Yadi",
    "Vincent Setiawan",
    "Aurell Joe",
    "Santoso Subekti",
    "Emma Watson",
    "Tom Kirma",
    "Angel Setiawan",
    "Marvel Cahyadi",
    "Fatmawati")

    private val noHpPenjualLaptop = arrayListOf("08214379372",
    "08254763473",
    "08324726384",
    "08273847632",
    "08237463287",
    "08238674238",
    "08327462388",
    "08586796578",
    "08547659867",
    "08560870650",
    "08345795486",
    "08467805859")

    private val photoPenjualLaptop = arrayListOf(R.drawable.man1,
    R.drawable.girl1,
    R.drawable.man2,
    R.drawable.girl2,
    R.drawable.man3,
    R.drawable.girl3,
    R.drawable.man4,
    R.drawable.girl4,
    R.drawable.man5,
    R.drawable.girl5,
    R.drawable.man6,
    R.drawable.girl6)

    val listData: ArrayList<ModelLaptop>
        get(){
            val listLaptop = arrayListOf<ModelLaptop>()
            for(position in merkLaptop.indices) {
                val modelLaptop = ModelLaptop()
                modelLaptop.merk = merkLaptop[position]
                modelLaptop.name = namaLaptop[position]
                modelLaptop.desc = descLaptop[position]
                modelLaptop.photo = photoLaptop[position]
                modelLaptop.harga = hargaLaptop[position]
                modelLaptop.namaPenjual = namaPenjualLaptop[position]
                modelLaptop.photoPenjual = photoPenjualLaptop[position]
                modelLaptop.noHpPenjual = noHpPenjualLaptop[position]

                listLaptop.add(modelLaptop)
            }
            return listLaptop
        }
}