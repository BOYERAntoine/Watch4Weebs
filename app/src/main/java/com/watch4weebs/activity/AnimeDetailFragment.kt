package com.watch4weebs.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.watch4weebs.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeDetailFragment : Fragment() {

    companion object {

        fun newInstance(): AnimeDetailFragment {
            return AnimeDetailFragment()
        }
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_anime_detail, container, false)
        view.findViewById<TextView>(R.id.anime_detail_name).text = arguments?.getString("anime_name")
        view.findViewById<TextView>(R.id.anime_detail_author).text = arguments?.getString("anime_author")
        return view
    }

}