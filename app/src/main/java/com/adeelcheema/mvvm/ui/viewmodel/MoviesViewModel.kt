package com.adeelcheema.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adeelcheema.mvvm.data.repositeries.MovieRepostery
import com.adeelcheema.mvvm.data.model.Movies
import com.adeelcheema.mvvm.util.Corountines
import kotlinx.coroutines.Job

class MoviesViewModel(private val repostery: MovieRepostery) : ViewModel() {

    private lateinit var job: Job

    val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>>
        get() = _movies

     fun getMovies() {

        job = Corountines.ioThreadMain(
            { repostery.getMovies() }, {
                _movies.value = it
            }
        )


    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}