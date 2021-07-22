package com.example.caritop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.Exception

class WishlistActivity : AppCompatActivity() {

    private lateinit var rv_wishlist: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)
        supportActionBar?.title = "My Wishlist"
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        rv_wishlist = findViewById(R.id.rv_wishlist)
        rv_wishlist.setHasFixedSize(true)

        // Jika wishlist kosong, intent ke empty
        try {
            loadAllWishlist()
        } catch (e:Exception){}

        showRecyclerWishlist()
    }

    private fun showRecyclerWishlist() {
        rv_wishlist.layoutManager = LinearLayoutManager(this)
        val wishlistAdapter = WishlistAdapter(DetailActivity().getDataWishlist())
        rv_wishlist.adapter = wishlistAdapter

        wishlistAdapter.setOnItemClickCallback(object: WishlistAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ModelLaptop) {
                goToDetail(data)
            }
        })
    }

    private fun goToDetail(data: ModelLaptop) {
        val listToDetail: ArrayList<ModelLaptop> = arrayListOf()
        val modelLaptop = ModelLaptop()
        modelLaptop.merk = data.merk
        modelLaptop.name = data.name
        modelLaptop.photo = data.photo
        modelLaptop.desc = data.desc
        modelLaptop.harga = data.harga
        modelLaptop.namaPenjual = data.namaPenjual
        modelLaptop.photoPenjual = data.photoPenjual
        modelLaptop.noHpPenjual = data.noHpPenjual
        listToDetail.add(modelLaptop)

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("indices", listToDetail)
        intent.putExtra("from", "WishlistActivity")
        startActivity(intent)
        this.finish()
    }

    fun loadAllWishlist() {
        loadNamaWishlist()
        loadPhotoWishlist()
        loadDescWishlist()
        loadHargaWishlist()
        loadNamaPenjualWishlist()
        loadPhotoPenjualWishlist()
        loadNoHpPenjualWishlist()

    }

    private fun loadNamaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_NAMA, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_NAMA, null)
        val type = object : TypeToken<ArrayList<String>>() {}.type
        DetailActivity.dataW.nama = gson.fromJson(json, type)

    }

    private fun loadPhotoWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_PHOTO, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_PHOTO, null)
        val type = object : TypeToken<ArrayList<Int>>() {}.type
        DetailActivity.dataW.photo = gson.fromJson(json, type)

    }

    private fun loadDescWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_DESC, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString(DetailActivity.STATE_DESC, null)
        val type = object : TypeToken<ArrayList<String>>() {}.type
        DetailActivity.dataW.desc = gson.fromJson(json, type)

    }

    private fun loadHargaWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_HARGA, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_HARGA, null)
        val type = object : TypeToken<ArrayList<String>>() {}.type
        DetailActivity.dataW.harga = gson.fromJson(json, type)
    }

    private fun loadNamaPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_NAMA_PENJUAL, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_NAMA_PENJUAL, null)
        val type = object : TypeToken<ArrayList<String>>() {}.type
        DetailActivity.dataW.namaPenjual = gson.fromJson(json, type)
    }

    private fun loadPhotoPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_PHOTO_PENJUAL, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_PHOTO_PENJUAL, null)
        val type = object : TypeToken<ArrayList<Int>>() {}.type
        DetailActivity.dataW.photoPenjual = gson.fromJson(json, type)
    }

    private fun loadNoHpPenjualWishlist() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(DetailActivity.SHARED_PREFS_NOHP_PENJUAL, Context.MODE_PRIVATE)
        val gson = Gson()
        val json  = sharedPreferences.getString(DetailActivity.STATE_NOHP_PENJUAL, null)
        val type = object : TypeToken<ArrayList<String>>() {}.type
        DetailActivity.dataW.noHpPenjual = gson.fromJson(json, type)
    }
}
