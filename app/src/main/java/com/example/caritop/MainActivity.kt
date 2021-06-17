package com.example.caritop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    private var list: ArrayList<ModelLaptop> = arrayListOf()
    private lateinit var rv_laptop: RecyclerView
    private var title: String = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(title)

        this.list.addAll(DataLaptop().listData)
        rv_laptop = findViewById(R.id.rv_laptop)
        rv_laptop.setHasFixedSize(true)

        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selected: Int) {
        when(selected) {
            R.id.action_home -> {
                title = "Home"
                showRecyclerList()
            }
            R.id.action_wishlist -> {
                val intent = Intent(this, WishlistActivity::class.java)
                startActivity(intent)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showRecyclerList() {
        // set adapter
        rv_laptop.layoutManager = LinearLayoutManager(this)
        var listAdapter = ListLaptopAdapter(list)
        rv_laptop.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object : ListLaptopAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelLaptop) {
                goToDetail(data)
            }
        })
    }


    private fun goToDetail(data: ModelLaptop) {
        var listToDetail: ArrayList<ModelLaptop> = arrayListOf()
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
        intent.putExtra("from", "MainActivity")
        startActivity(intent)
        this.finish()

    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }

}
