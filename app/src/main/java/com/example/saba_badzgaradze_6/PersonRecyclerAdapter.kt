package com.example.saba_badzgaradze_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonRecyclerAdapter(private val persons: List<Person>): RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView = itemView.findViewById<TextView>(R.id.textView)
        private val textView2 = itemView.findViewById<TextView>(R.id.textView2)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun setData(person: Person){

            textView.text = person.firstName
            textView2.text = person.lastName

            Glide
                .with(itemView)
                .load(person.avatar)
                .into(imageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(itemView)

    }

    override fun getItemCount() = persons.size


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        holder.setData(persons[position])

    }
}