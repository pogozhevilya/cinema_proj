package org.project.repository;

import org.project.entity.Movie;

import java.util.List;

public interface MovieRepository {
    Movie findMovieById(int id);

    Movie findMovieByTitle(String title);

    List<Movie> findAllMovies();
}
