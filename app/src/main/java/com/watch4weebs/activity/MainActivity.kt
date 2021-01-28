package com.watch4weebs.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.watch4weebs.R
import com.watch4weebs.`class`.Anime
import com.watch4weebs.activity.AnimeDetailFragment.Companion.newInstance

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fma = Anime(name = "full metal alchemist",id="0", author = "la bosse en fait")

        if (savedInstanceState == null) {
            // 2
            supportFragmentManager
                // 3
                .beginTransaction()
                // 4
                .add(R.id.root_layout, AnimeList(), "animeList")
                // 5
                .commit()
        }
    }
}