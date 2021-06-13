package com.example.caritop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.Gson


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvNama: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvDesc: TextView
    private lateinit var btnWishlist: Button
    private lateinit var listLaptop: ArrayList<ModelLaptop>

    companion object {
        const val SHARED_PREFS_NAMA = "shared_prefs_nama"
        const val SHARED_PREFS_PHOTO = "shared_prefs_photo"
        const val SHARED_PREFS_DESC = "shared_prefs_desc"
        const val SHARED_PREFS_HARGA = "shared_prefs_harga"
        const val STATE_NAMA = "state_nama"
        const val STATE_PHOTO = "state_photo"
        const val STATE_DESC = "state_desc"
        const val STATE_HARGA = "state_harga"
    }

    object dataW {
        var nama: ArrayList<String> = arrayListOf()
        var photo: ArrayList<Int> = arrayListOf()
        var desc: ArrayList<String> = arrayListOf()
        var harga: ArrayList<String> = arrayListOf()

        val dataWishlist: ArrayList<ModelLaptop>
            get() {
                val list: ArrayList<ModelLaptop> = arrayListOf()
                for(position in nama.indices) {
                    val mL = ModelLaptop()
                    mL.photo = photo[position]
                    mL.name = nama[position]
                    mL.desc = desc[position]
                    mL.harga = harga[position]
                    list.add(mL)
                }
                return list
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail"
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        imgPhoto = findViewById(R.id.img_photo)
        tvNama = findViewById(R.id.tv_nama_laptop)
        tvHarga = findViewById(R.id.tv_harga_laptop)
        tvDesc = findViewById(R.id.tv_info_laptop)
        btnWishlist = findViewById(R.id.btn_wishlist)

        listLaptop = intent.getParcelableArrayListExtra("indices")
        setDetailLaptop(listLaptop)

        if (isAlreadyinWishlist()) {
            btnWishlist.setText("Unfavorite")
        }

        btnWishlist.setOnClickListener(this)
    }

    private fun setDetailLaptop(list: ArrayList<ModelLaptop>) {
        Glide.with(this)
            .load(list[0].photo)
            .into(imgPhoto)
        tvNama.text = list[0].name
        tvHarga.text = list[0].harga
        tvDesc.text = list[0].desc

        val harga = list[0].harga
    }

    private fun isAlreadyinWishlist(): Boolean {
        if (dataW.nama.contains(listLaptop[0].name)) {
            return true
        }
        return false
    }

    fun getDataWishlist(): ArrayList<ModelLaptop> {
        var listData: ArrayList<ModelLaptop> = arrayListOf()
        listData.addAll(dataW.dataWishlist)
        return listData
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_wishlist -> {
                val listNama = listLaptop[0].name
                val listPhoto = listLaptop[0].photo
                val listDesc = listLaptop[0].desc
                val listHarga = listLaptop[0].harga

                if (!isAlreadyinWishlist()) {
                    dataW.nama.add(listNama)
                    dataW.photo.add(listPhoto)
                    dataW.desc.add(listDesc)
                    dataW.harga.add(listHarga)

                    saveNamaWishlist()
                    savePhotoWishlist()
                    saveDescWishlist()
                    saveHargaWishlist()
                    Toast.makeText(this, "$listNama masuk ke list favorit!", Toast.LENGTH_SHORT).show()
                    btnWishlist.setText("Unfavorite")
                } else {
                    val position = dataW.nama.indexOf(listLaptop[0].name)
                    dataW.nama.removeAt(position)
                    dataW.photo.removeAt(position)
                    dataW.desc.removeAt(position)
                    dataW.harga.removeAt(position)

                    saveNamaWishlist()
                    savePhotoWishlist()
                    saveDescWishlist()
                    saveHargaWishlist()
                    Toast.makeText(this, "$listNama dihapus dari favorit!", Toast.LENGTH_SHORT).show()
                    btnWishlist.setText("Favorite")
                }
            }
        }
    }

     fun saveNamaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_NAMA, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.nama)
        editor.putString(STATE_NAMA, json)
        editor.apply()
    }

     fun savePhotoWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_PHOTO, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.photo)
        editor.putString(STATE_PHOTO, json)
        editor.apply()
    }

    fun saveDescWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_DESC, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.desc)
        editor.putString(STATE_DESC, json)
        editor.apply()
    }

    fun saveHargaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_HARGA, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.harga)
        editor.putString(STATE_HARGA, json)
        editor.apply()
    }

    override fun onBackPressed() {
        var myIntent: Intent? = null
        var source = intent.getStringExtra("from")

        when(source) {
            "WishlistActivity" -> {
                myIntent = Intent(this, WishlistActivity::class.java)
            }
            "MainActivity" -> {
                myIntent = Intent(this, MainActivity::class.java)
            }
        }

        startActivity(myIntent)
        return super.onBackPressed()
    }


}
