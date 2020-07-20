package com.adeelcheema.mvvm.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adeelcheema.mvvm.R
import com.adeelcheema.mvvm.data.model.Movies
import com.adeelcheema.mvvm.data.repositeries.MovieRepostery
import com.adeelcheema.mvvm.data.network.MoviesApi
import com.adeelcheema.mvvm.ui.adapter.MoviesAdapter
import com.adeelcheema.mvvm.ui.viewmodel.MovieFactory
import com.adeelcheema.mvvm.ui.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(), callbackListeners {
    private lateinit var factory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repostery =
            MovieRepostery(api)
        factory = MovieFactory(repostery)
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            movieRecyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter =
                    MoviesAdapter(movies, this)
            }
        })
    }

    override fun recyclerItemClickListener(view: View, movie: Movies) {
        when (view.id) {
            R.id.button -> {
                Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

}