package org.project.repository;

import org.project.entity.Movie;
import org.project.entity.Show;

import java.util.List;

public interface ShowRepository {
    Show findShowById(int id);

    Show findShowByMovie(Movie movie);

    List<Show> findAllShows();
}
