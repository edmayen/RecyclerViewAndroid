package com.dev.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev.recyclerview.R
import com.dev.recyclerview.base.BaseViewHolder
import com.dev.recyclerview.models.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalAdapter(
    private val context: Context,
    private val animalList: List<Animal>,
    private val itemClickListener: OnAnimalClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnAnimalClickListener{
        fun onImageClick(image: String)
        fun onItemClick(name: String)
    }

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
            itemView.setOnClickListener {
                itemClickListener.onItemClick(item.name)
            }
            itemView.imgAnimal.setOnClickListener {
                itemClickListener.onImageClick(item.image)
            }
            Glide.with(context).load(item.image).centerCrop().into(itemView.imgAnimal)
            itemView.tvAnimalName.text = item.name
        }
    }

}