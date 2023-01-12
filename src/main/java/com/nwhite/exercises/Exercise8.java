package com.nwhite.exercises;

import com.nwhite.domain.Movie;
import com.nwhite.service.InMemoryMovieService;
import com.nwhite.service.MovieService;

import java.util.stream.Collectors;

public class Exercise8 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Group the movies by the year and list them
        var moviesByYear =
                movieService.findAllMovies().stream()
                        .collect(Collectors.groupingBy(Movie::getYear));
        moviesByYear.forEach((year,movies) -> System.out.printf("%d: %s\n",year,movies));
    }

}
