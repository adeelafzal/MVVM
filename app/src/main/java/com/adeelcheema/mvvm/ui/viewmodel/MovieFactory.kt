package com.adeelcheema.mvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adeelcheema.mvvm.data.repositeries.MovieRepostery

@Suppress("UNCHECKED_CAST")
class MovieFactory(private val repostery: MovieRepostery) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repostery) as T
    }

}