package org.project.repository.impl;

import org.project.entity.Movie;
import org.project.entity.Show;
import org.project.repository.MovieRepository;
import org.project.repository.ShowRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

public class ShowRepositoryImpl implements ShowRepository {
    private static final List<Show> STATE = new ArrayList<>();
    private static ShowRepository instance;

    static {
        MovieRepository movieRepository = MovieRepositoryImpl.getInstance();
        STATE.addAll(List.of(
                new Show(1, movieRepository.findMovieById(1), "5:30pm", 100),
                new Show(2, movieRepository.findMovieById(2), "7:00pm", 300),
                new Show(3, movieRepository.findMovieById(3), "6:00pm", 200),
                new Show(4, movieRepository.findMovieById(4), "9:00pm", 200)
        ));
    }

    public static synchronized ShowRepository getInstance() {
        if (isNull(instance)) {
            instance = new ShowRepositoryImpl();
        }
        return instance;
    }

    @Override
    public synchronized Show findShowById(int id) {
        for (Show show : STATE) {
            if (show.getId() == id)
                return show;
        }
        return null;
    }

    @Override
    public synchronized Show findShowByMovie(Movie movie) {
        for (Show show : STATE) {
            if (Objects.equals(show.getMovie().getId(), movie.getId()))
                return show;
        }
        return null;
    }

    @Override
    public synchronized List<Show> findAllShows() {
        return STATE;
    }
}
