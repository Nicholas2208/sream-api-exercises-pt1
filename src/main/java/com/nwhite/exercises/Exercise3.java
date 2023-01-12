package com.nwhite.exercises;

import com.nwhite.service.InMemoryMovieService;
import com.nwhite.service.MovieService;

import java.util.Collection;
import java.util.stream.Collectors;

public class Exercise3 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the number of genres of each director's movies
        var directorGenreNumbers =
                movieService.findAllMovies()
                        .stream()
                        .map( movie -> movie.getDirectors().stream().map(director -> new DirectorGenresPair(director,movie.getGenres())).toList())
                        .flatMap(Collection::stream)
                        .map( directorGenres -> directorGenres.genres().stream().map( genre -> new DirectorGenrePair(directorGenres.director(),genre) ).toList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(DirectorGenrePair::director,Collectors.groupingBy(DirectorGenrePair::genre,Collectors.counting())));
        directorGenreNumbers.forEach((director,genreCounts)->{
            System.out.printf("%s\n",director.getName());
            genreCounts.forEach( (genre,count) -> System.out.printf("\t%s: %s\n",genre.getName(),count));
        });
    }

}
