package com.adeelcheema.mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.adeelcheema.mvvm.R
import com.adeelcheema.mvvm.data.model.Movies
import com.adeelcheema.mvvm.databinding.MovieItemBinding
import com.adeelcheema.mvvm.ui.callbackListeners

class MoviesAdapter(val moviesList: List<Movies>, val listenr: callbackListeners) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item, parent, false
            )
        )


    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieItemBinding.viewmodel = moviesList[position]
        holder.movieItemBinding.root.setOnClickListener {
            listenr.recyclerItemClickListener(
                holder.movieItemBinding.root,
                moviesList[position]
            )
        }
    }

    inner class ViewHolder(val movieItemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root) {

    }

}