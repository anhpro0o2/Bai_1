package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.userName)
        val emailTextView: TextView = view.findViewById(R.id.userEmail)
        val phoneTextView: TextView = view.findViewById(R.id.userPhone)
        val genderTextView: TextView = view.findViewById(R.id.userGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.phoneTextView.text = user.phone
        holder.genderTextView.text = user.gender
    }

    override fun getItemCount(): Int {
        return users.size
    }
}