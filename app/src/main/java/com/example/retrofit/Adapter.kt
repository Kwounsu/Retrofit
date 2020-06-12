package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class Adapter(var userList: List<User>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.text_id)
        val name: TextView = itemView.findViewById(R.id.text_name)
        val username: TextView = itemView.findViewById(R.id.text_username)
        val email: TextView = itemView.findViewById(R.id.text_email)
        val phone: TextView = itemView.findViewById(R.id.text_phone)
        val website: TextView = itemView.findViewById(R.id.text_website)
        val street: TextView = itemView.findViewById(R.id.text_street)
        val suite: TextView = itemView.findViewById(R.id.text_suite)
        val city: TextView = itemView.findViewById(R.id.text_city)
        val zipcode: TextView = itemView.findViewById(R.id.text_zipcode)
        val lat: TextView = itemView.findViewById(R.id.text_lat)
        val lng: TextView = itemView.findViewById(R.id.text_lng)
        val company: TextView = itemView.findViewById(R.id.text_company)
        val catchPhrase: TextView = itemView.findViewById(R.id.text_catchPhrase)
        val bs: TextView = itemView.findViewById(R.id.text_bs)

        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val user = userList[position]
        holder.id.text = user.id.toString()
        holder.name.text = user.name
        holder.username.text = user.username
        holder.email.text = user.email
        holder.phone.text = user.phone
        holder.website.text = user.website
        holder.street.text = user.address.street
        holder.suite.text = user.address.suite
        holder.city.text = user.address.city
        holder.zipcode.text = user.address.zipcode
        holder.lat.text = user.address.geo.lat
        holder.lng.text = user.address.geo.lng
        holder.company.text = user.company.name
        holder.catchPhrase.text = user.company.catchPhrase
        holder.bs.text = user.company.bs

        holder.imageView.setImageResource(R.drawable.ic_launcher_foreground)
        if (position%2 == 0) {
            Glide.with(holder.id.context)
                .load("https://pixabay.com/get/53e2d0414955ae14f6d1867dda35367b1c3ed7ed5551734a_1920.jpg")
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView)
        } else {
            Picasso.with(holder.itemView.context)
                .load("https://pixabay.com/get/53e2d6444955a814f6d1867dda35367b1c3ed7ed55507040_1920.jpg")
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView)
        }
    }
}