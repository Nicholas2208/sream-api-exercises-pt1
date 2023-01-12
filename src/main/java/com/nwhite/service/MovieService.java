package com.nwhite.service;

import com.nwhite.domain.Genre;
import com.nwhite.domain.Movie;

import java.util.Collection;

public interface MovieService {
    Movie findMovieById(int id);

    Collection<Movie> findAllMovies();

    Genre findGenreByName(String genre);
}
