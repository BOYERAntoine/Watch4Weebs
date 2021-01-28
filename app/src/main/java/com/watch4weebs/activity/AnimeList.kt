package com.watch4weebs.activity

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.watch4weebs.R
import com.watch4weebs.`class`.Anime
import com.watch4weebs.adapter.AnimeAdapter

//import androidx.appcompat.widget.
/*
*
* */


class AnimeList : Fragment(){

    private val animeList = ArrayList<Anime>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadAnimeData()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_anime_list, container, false)

        val lv = view.findViewById<ListView>(R.id.anime_list)

        //val seattleAttractions = getAttractionsByPlace("Seattle")
        val animeAdapter = context?.let { AnimeAdapter(animeList, it) }
        lv.adapter = animeAdapter

        lv.dividerHeight = 10

        lv.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            Toast.makeText(activity,
                "you selected anime " + (i + 1),
                Toast.LENGTH_LONG).show()
        }
        return view
    }

    private fun loadAnimeData() {
        //val newAnimeList = ArrayList<Anime>()
        animeList.add(Anime(name = "One Piece",id="0", author = "Oda"));

        animeList.add(Anime(name = "Naruto",id="1", author = "Kishimoto"))
        animeList.add(Anime(name = "Naruto Shippuden",id="1", author = "Kishimoto"))

        animeList.add(Anime(name = "Hunter x Hunter",id="2", author = "Togashi"))

        animeList.add(Anime(name = "Bleach",id="3", author = "Kubo"))
        animeList.add(Anime(name = "Dragon Ball",id="4", author = "Toriyama"))
        animeList.add(Anime(name = "Dragon Ball Z",id="4", author = "Toriyama"))
        animeList.add(Anime(name = "Dragon Ball Super",id="4", author = "Toriyama"))
        animeList.add(Anime(name = "Dragon Ball GT ",id="4", author = "Toriyama"))
        animeList.add(Anime(name = "full metal alchemist",id="5", author = "la bosse en fait"))

    }
}

