package com.adeelcheema.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adeelcheema.mvvm.R
import com.adeelcheema.mvvm.data.repositeries.MovieRepostery
import com.adeelcheema.mvvm.data.network.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repostery =
            MovieRepostery(MoviesApi())

        GlobalScope.launch(Dispatchers.Main) {
            val movies = repostery.getMovies()
            Toast.makeText(this@MainActivity,movies.toString(),Toast.LENGTH_LONG).show()
        }

    }
}