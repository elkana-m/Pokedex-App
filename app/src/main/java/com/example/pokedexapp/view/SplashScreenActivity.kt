package com.example.pokedexapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexapp.R

class SplashScreenActivity: AppCompatActivity() {
    private lateinit var icon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash_screen)

        bindViews()
        createSplashScreen()

    }


    private fun bindViews(){
        icon = findViewById(R.id.iv_icon)
    }

    private fun createSplashScreen(){
        icon.alpha = 0f
        icon.animate().setDuration(1500).alpha(1f).withEndAction{
            val intent = Intent(this, ListPokemonActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}