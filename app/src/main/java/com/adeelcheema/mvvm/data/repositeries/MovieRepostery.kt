package com.adeelcheema.mvvm.data.repositeries

import com.adeelcheema.mvvm.data.network.MoviesApi

class MovieRepostery(private val api: MoviesApi) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}