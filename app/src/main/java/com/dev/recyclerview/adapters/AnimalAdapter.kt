package com.dev.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.recyclerview.R
import com.dev.recyclerview.base.BaseViewHolder
import com.dev.recyclerview.models.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalAdapter(private val context: Context, val animalList: List<Animal>): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimalsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false))
    }

    override fun getItemCount(): Int = animalList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is AnimalsViewHolder -> holder.bind(animalList[position], position)
            else -> throw IllegalArgumentException("No ViewModel on bind")
        }
    }

    inner class AnimalsViewHolder(itemView: View): BaseViewHolder<Animal>(itemView){
        override fun bind(item: Animal, position: Int) {
            Glide.with(context).load(item.image).into(itemView.imgAnimal)
            itemView.tvAnimalName.text = item.name
        }
    }

}