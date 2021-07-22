package com.example.caritop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvNama: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvDesc: TextView
    private lateinit var btnWishlist: Button
    private lateinit var photoPenjual: ImageView
    private lateinit var tvNamaPenjual: TextView
    private lateinit var btnCall: Button
    private lateinit var listLaptop: ArrayList<ModelLaptop>

    companion object {
        const val SHARED_PREFS_NAMA = "shared_prefs_nama"
        const val SHARED_PREFS_PHOTO = "shared_prefs_photo"
        const val SHARED_PREFS_DESC = "shared_prefs_desc"
        const val SHARED_PREFS_HARGA = "shared_prefs_harga"
        const val SHARED_PREFS_NAMA_PENJUAL = "shared_prefs_nama_penjual"
        const val SHARED_PREFS_PHOTO_PENJUAL = "shared_prefs_photo_penjual"
        const val SHARED_PREFS_NOHP_PENJUAL = "shared_prefs_nohp_penjual"
        const val STATE_NAMA = "state_nama"
        const val STATE_PHOTO = "state_photo"
        const val STATE_DESC = "state_desc"
        const val STATE_HARGA = "state_harga"
        const val STATE_NAMA_PENJUAL = "state_nama_penjual"
        const val STATE_PHOTO_PENJUAL = "state_photo_penjual"
        const val STATE_NOHP_PENJUAL = "state_nohp_penjuaL"
    }

    object dataW {
        var nama: ArrayList<String> = arrayListOf()
        var photo: ArrayList<Int> = arrayListOf()
        var desc: ArrayList<String> = arrayListOf()
        var harga: ArrayList<String> = arrayListOf()
        var namaPenjual: ArrayList<String> = arrayListOf()
        var photoPenjual: ArrayList<Int> = arrayListOf()
        var noHpPenjual: ArrayList<String> = arrayListOf()

        val dataWishlist: ArrayList<ModelLaptop>
            get() {
                val list: ArrayList<ModelLaptop> = arrayListOf()
                for(position in nama.indices) {
                    val mL = ModelLaptop()
                    mL.photo = photo[position]
                    mL.name = nama[position]
                    mL.desc = desc[position]
                    mL.harga = harga[position]
                    mL.namaPenjual = namaPenjual[position]
                    mL.photoPenjual = photoPenjual[position]
                    mL.noHpPenjual = noHpPenjual[position]
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

        // deklarasi
        imgPhoto = findViewById(R.id.img_photo)
        photoPenjual = findViewById(R.id.photo_penjual)
        tvNama = findViewById(R.id.tv_nama_laptop)
        tvHarga = findViewById(R.id.tv_harga_laptop)
        tvDesc = findViewById(R.id.tv_info_laptop)
        tvNamaPenjual = findViewById(R.id.tv_nama_penjual)
        btnCall = findViewById(R.id.btn_call)
        btnWishlist = findViewById(R.id.btn_wishlist)

        listLaptop = intent.getParcelableArrayListExtra("indices")
        setDetailLaptop(listLaptop)

        if (isAlreadyinWishlist()) {
            btnWishlist.setText("Unfavorite")
        }

        btnWishlist.setOnClickListener(this)
        btnCall.setOnClickListener(this)
    }

    private fun setDetailLaptop(list: ArrayList<ModelLaptop>) {
        Glide.with(this)
            .load(list[0].photo)
            .into(imgPhoto)
        Glide.with(this)
            .load(list[0].photoPenjual)
            .into(photoPenjual)
        tvNama.text = list[0].name
        tvHarga.text = list[0].harga
        tvDesc.text = list[0].desc
        tvNamaPenjual.text = list[0].namaPenjual

    }

    private fun isAlreadyinWishlist(): Boolean {
        if (dataW.nama.contains(listLaptop[0].name)) {
            return true
        }
        return false
    }

    // mengirimkan data ke wishlist
    fun getDataWishlist(): ArrayList<ModelLaptop> {
        val listData: ArrayList<ModelLaptop> = arrayListOf()
        listData.addAll(dataW.dataWishlist)
        return listData
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_wishlist -> {
                // jika diklik, ambil data dari detail
                val listNama = listLaptop[0].name
                val listPhoto = listLaptop[0].photo
                val listDesc = listLaptop[0].desc
                val listHarga = listLaptop[0].harga
                val listNamaPenjual = listLaptop[0].namaPenjual
                val listPhotoPenjual = listLaptop[0].photoPenjual
                val listNoHpPenjual = listLaptop[0].noHpPenjual

                if (!isAlreadyinWishlist()) {
                    // jika belum ada di wishlist, ditambahkan ke wishlist
                    dataW.nama.add(listNama)
                    dataW.photo.add(listPhoto)
                    dataW.desc.add(listDesc)
                    dataW.harga.add(listHarga)
                    dataW.namaPenjual.add(listNamaPenjual)
                    dataW.photoPenjual.add(listPhotoPenjual)
                    dataW.noHpPenjual.add(listNoHpPenjual)

                    saveAllWishlist()
                    val snackbar: Snackbar = Snackbar.make(v, "$listNama masuk ke list favorit!", Snackbar.LENGTH_SHORT)
                    snackbar.show()
//                    Toast.makeText(this, "$listNama masuk ke list favorit!", Toast.LENGTH_SHORT).show()
                    btnWishlist.setText("Unfavorite")
                } else {
                    val position = dataW.nama.indexOf(listLaptop[0].name)
                    dataW.nama.removeAt(position)
                    dataW.photo.removeAt(position)
                    dataW.desc.removeAt(position)
                    dataW.harga.removeAt(position)
                    dataW.namaPenjual.removeAt(position)
                    dataW.photoPenjual.removeAt(position)
                    dataW.noHpPenjual.removeAt(position)

                    saveAllWishlist()
                    val snackbar: Snackbar = Snackbar.make(v, "$listNama dihapus dari favorit!", Snackbar.LENGTH_SHORT)
                    snackbar.show()
//                    Toast.makeText(this, "$listNama dihapus dari favorit!", Toast.LENGTH_SHORT).show()
                    btnWishlist.setText("Favorite")
                }
            }
            R.id.btn_call -> {
                val noHpPenjual: String = listLaptop[0].noHpPenjual
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$noHpPenjual"))
                startActivity(intent)
            }
        }
    }

    fun saveAllWishlist() {
        saveNamaWishlist()
        savePhotoWishlist()
        saveDescWishlist()
        saveHargaWishlist()
        saveNamaPenjualWishlist()
        savePhotoPenjualWishlist()
        saveNoHpPenjualWishlist()
    }

    private fun saveNamaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_NAMA, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.nama)
        editor.putString(STATE_NAMA, json)
        editor.apply()
    }

    private fun savePhotoWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_PHOTO, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.photo)
        editor.putString(STATE_PHOTO, json)
        editor.apply()
    }

    private fun saveDescWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_DESC, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.desc)
        editor.putString(STATE_DESC, json)
        editor.apply()
    }

    private fun saveHargaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_HARGA, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.harga)
        editor.putString(STATE_HARGA, json)
        editor.apply()
    }

    private fun saveNamaPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_NAMA_PENJUAL, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.namaPenjual)
        editor.putString(STATE_NAMA_PENJUAL, json)
        editor.apply()
    }

    private fun savePhotoPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_PHOTO_PENJUAL, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.photoPenjual)
        editor.putString(STATE_PHOTO_PENJUAL, json)
        editor.apply()
    }

    private fun saveNoHpPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS_NOHP_PENJUAL, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(dataW.noHpPenjual)
        editor.putString(STATE_NOHP_PENJUAL, json)
        editor.apply()
    }

    override fun onBackPressed() {
        var myIntent: Intent? = null
        val source = intent.getStringExtra("from")

        when(source) {
            "WishlistActivity" -> {
                myIntent = Intent(this, WishlistActivity::class.java)
            }
            "MainActivity" -> {
                MainActivity.thisActivity.main.finish()
                myIntent = Intent(this, MainActivity::class.java)
            }
        }

        startActivity(myIntent)
        return super.onBackPressed()
    }


}
