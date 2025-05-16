package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//Adaptacao entre o data class e o item_list layout
class DogsListAdapter :
    ListAdapter<Dogs, DogsListAdapter.DogViewHolder>(DogDiffUtils()) {

    //Criar um view holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return DogViewHolder(view)
    }

    // bind - atrelar o dado com a UI views
    override fun onBindViewHolder(
        holder: DogViewHolder,
        position: Int
    ) {
        val dog = getItem(position)
        holder.bind(dog)
    }


    //View holder = view que segura os dados
    class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvBreed = view.findViewById<TextView>(R.id.tv_breed)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(dogs: Dogs) {
            tvName.text = dogs.name
            tvBreed.text = dogs.breed
            image.setImageResource(dogs.icon)
        }

    }

    //Compara a diferenca quando a nossa lista e atualizada
    class DogDiffUtils : DiffUtil.ItemCallback<Dogs>() {
        override fun areItemsTheSame(
            oldItem: Dogs,
            newItem: Dogs
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Dogs,
            newItem: Dogs
        ): Boolean {
            return oldItem.name == newItem.name
        }

    }
}