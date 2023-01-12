package com.nwhite.exercises;

import com.nwhite.domain.Director;
import com.nwhite.domain.Genre;

import java.util.List;

public record DirectorGenresPair(Director director, List<Genre> genres) {
}
