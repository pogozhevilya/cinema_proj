package org.project.repository.impl;

import org.project.entity.Movie;

import org.project.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

public class MovieRepositoryImpl implements MovieRepository {
    private static final List<Movie> STATE = new ArrayList<>();
    private static MovieRepository instance;

    static {
        STATE.addAll(List.of(
                new Movie(1, "World of warcraft"),
                new Movie(2, "A Bug's Life"),
                new Movie(3, "No county for old men"),
                new Movie(4, "Return to me"),
                new Movie(5, "Programmers")
        ));
    }

    public static synchronized MovieRepository getInstance() {
        if (isNull(instance)) {
            instance = new MovieRepositoryImpl();
        }
        return instance;
    }

    @Override
    public synchronized Movie findMovieById(int id) {
        for (Movie movie : STATE) {
            if (movie.getId() == id)
                return movie;
        }
        return null;
    }

    @Override
    public synchronized Movie findMovieByTitle(String title) {
        for (Movie movie : STATE) {
            if (Objects.equals(movie.getTitle(), title))
                return movie;
        }
        return null;
    }

    @Override
    public synchronized List<Movie> findAllMovies() {
        return STATE;
    }
}
