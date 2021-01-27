package com.watch4weebs.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

public class AnimeAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val recyclerDogModelBinding =
            RecyclerItemDogModelBinding.inflate(layoutInflater, viewGroup, false)
        return ViewHolder(recyclerDogModelBinding.root, recyclerDogModelBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val dog = DogModel(imageResIds[position], names[position],
            descriptions[position], urls[position])
        viewHolder.setData(dog)
        viewHolder.itemView.setOnClickListener { listener.onDogSelected(dog) }
    }

    override fun getItemCount() = names.size
    }


class ViewHolder constructor(itemView: View,
                                   private val recyclerItemDogListBinding:
                                            RecyclerItemDogModelBinding
) :
    RecyclerView.ViewHolder(itemView) {

    fun setData(dogModel: DogModel) {
        recyclerItemDogListBinding.dogModel = dogModel
    }
}

interface OnDogSelected {
    fun onDogSelected(dogModel: DogModel)
}

}
