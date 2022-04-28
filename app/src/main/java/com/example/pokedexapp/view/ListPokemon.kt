package com.example.pokedexapp.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapp.R
import com.example.pokedexapp.dto.Results
import com.google.android.material.snackbar.Snackbar

class ListPokemon : AppCompatActivity(), ListsView {
    lateinit var presenter: ListsPresenter

    lateinit var container: View
    lateinit var pageIndex: EditText
    lateinit var btnToRefresh: Button
    lateinit var recyclerview: RecyclerView
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)


        bindViews()

        presenter = ListsPresenterFactory.createPresenter(this)
        presenter.start()

    }

    override fun onDestroy(){
        super.onDestroy()

        // Save data when activity is destroyed
        var editor = preferences.edit()
        editor.putInt("pageIndex",pageIndex.text.toString().toInt())
        editor.apply()
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun bindPokemon(pokeList: List<Results?>)
    {
        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = ListPokemonAdapter(pokeList, this)
        recyclerview.adapter = adapter


        adapter.setOnItemClickListener(object : ListPokemonAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                // Toast.makeText(this@ListPokemon, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun queryBtn(): Button
    {
        return btnToRefresh
    }

    override fun findPageIndex():Int
    {
        var isPageIndex = pageIndex.text.toString().toIntOrNull()

        if (isPageIndex == null)
        {
            Toast.makeText(this@ListPokemon, "Must be a digit", Toast.LENGTH_SHORT).show()
            pageIndex.setText("1")
        }
        return pageIndex.text.toString().toInt()
    }

    private fun bindViews()
    {
        supportActionBar!!.title = "Pokedex"
        container = findViewById(R.id.container)
        recyclerview = findViewById(R.id.recyclerView)
        pageIndex = findViewById(R.id.pageIndex)
        btnToRefresh = findViewById(R.id.btnToRefresh)

        preferences = getSharedPreferences("indexQuery", Context.MODE_PRIVATE)
        val getter = preferences.getInt("pageIndex", 1)
        pageIndex.setText(getter.toString())
    }

}