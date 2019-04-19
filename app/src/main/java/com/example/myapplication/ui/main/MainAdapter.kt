package com.example.myapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Repo
import kotlinx.android.synthetic.main.item_main.view.*
import javax.inject.Inject


class MainAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var repos: List<Repo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_main, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemCount() = repos.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val repo = repos[position]
        viewHolder.itemView.text_view_id.text = repo.id.toString()
        viewHolder.itemView.text_view_name.text = repo.name
        viewHolder.itemView.text_view_description.text = repo.description
    }

    fun updateData(repos: List<Repo>) {
        this.repos = repos
        notifyDataSetChanged()
    }
}