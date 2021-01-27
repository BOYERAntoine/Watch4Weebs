package com.watch4weebs.activity

import android.content.Context
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.watch4weebs.R
import com.watch4weebs.`class`.Anime
import com.watch4weebs.adapter.AnimeAdapter

//import androidx.appcompat.widget.

class AnimeListFragment : Fragment() {
    private val animeList: MutableList<Anime> = ArrayList()
    private lateinit var listener: OnAnimeSelected

    companion object {

        fun newInstance(): AnimeListFragment {
            return AnimeListFragment()
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnAnimeSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnAnimeSelected.")
        }

        val resources = context.resources
        //val animeList: List<Anime> = ArrayList();

        animeList.add(Anime(name = "One Piece",id="0", author = "Oda"));
        animeList.add(Anime(name = "Naruto",id="1", author = "Kishimoto"))
        animeList.add(Anime(name = "Hunter x Hunter",id="2", author = "Togashi"))
        animeList.add(Anime(name = "Bleach",id="3", author = "Kubo"))
        animeList.add(Anime(name = "Dragon Ball",id="4", author = "Toriyama"))
        //names = resources.getStringArray(R.array.names)
        //descriptions = resources.getStringArray(R.array.descriptions)
        //urls = resources.getStringArray(R.array.urls)

        // Get dog images.
        /* val typedArray = resources.obtainTypedArray(R.array.images)
      val imageCount = names.size
      imageResIds = IntArray(imageCount)
      for (i in 0 until imageCount) {
          imageResIds[i] = typedArray.getResourceId(i, 0)
      }
      typedArray.recycle()*/
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_anime_list, container,
                false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = AnimeAdapter(activity)
        return view

    }

    internal inner class AnimeAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {

        private val layoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val recyclerDogModelBinding = RecyclerItemDogModelBinding.inflate(layoutInflater, viewGroup, false)
            return ViewHolder(recyclerDogModelBinding.root, recyclerDogModelBinding)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val anime = animeList[position];
            viewHolder.setData(anime)
            viewHolder.itemView.setOnClickListener { listener.OnAnimeSelected(anime) }
        }

        override fun getItemCount() = animeList.size
    }

    internal inner class ViewHolder constructor(itemView: View,
                                                private val recyclerItemDogListBinding:
                                                RecyclerItemDogModelBinding
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun setData(animeModel: Anime) {
            recyclerItemDogListBinding.dogModel = Anime()
        }
    }

    interface OnAnimeSelected {
        fun OnAnimeSelected(animeModel: Anime)
    }

}

