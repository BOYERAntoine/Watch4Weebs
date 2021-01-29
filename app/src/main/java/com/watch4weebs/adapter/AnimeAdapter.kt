package com.watch4weebs.adapter;

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.watch4weebs.R
import com.watch4weebs.`class`.Anime

class AnimeAdapter(items: ArrayList<Anime>, ctx: Context) :
    ArrayAdapter<Anime>(ctx, R.layout.anime_item, items) {

    private class AnimeItemViewHolder {
        internal var name: TextView? = null
        internal var author: TextView? = null
        internal var fav: ImageButton? = null
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val viewHolder: AnimeItemViewHolder

        if(view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.anime_item, parent, false)

            viewHolder = AnimeItemViewHolder()
            viewHolder.name = view!!.findViewById<View>(R.id.anime_name) as TextView
            viewHolder.author = view.findViewById<View>(R.id.anime_author) as TextView
            viewHolder.fav = view.findViewById<View>(R.id.anime_fav) as ImageButton
            //shows how to apply styles to views of item for specific item

        }
        else{
            viewHolder = view.tag as AnimeItemViewHolder
        }
        val anime = getItem(position)
        viewHolder.name!!.text = anime!!.name
        viewHolder.author!!.text = anime.author
        //viewHolder.hours!!.text = attraction.hours
        //viewHolder.image!!.setImageResource(attraction.image)

        //shows how to handle events of views of items
        viewHolder.fav!!.setOnClickListener {
            //Toast.makeText(context, "Clicked fav of " + anime!!.name, Toast.LENGTH_SHORT).show()
            Log.d("allo","hello")
        }
        view.tag = viewHolder

        return view
    }

}

