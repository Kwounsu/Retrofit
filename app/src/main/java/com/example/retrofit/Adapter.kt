package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var userList : List<User> = listOf()

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
    }

    fun setUserListItems(userList: List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }
}