package com.example.movieapp.models

data class MoviesModel(
    val page: Int,
    val results: List<MovieitemModel>,
    val total_pages: Int,
    val total_results: Int
)