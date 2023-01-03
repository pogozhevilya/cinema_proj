package org.project.entity;

import java.util.Objects;

public class Storage {
    private static Storage ourInstance;
    private final Movie[] movies;
    private final Show[] shows;

    public synchronized static Storage getInstance() {
        if (ourInstance == null) {
            ourInstance = new Storage();
        }
        return ourInstance;
    }

    private Storage() {
        movies = new Movie[]{
                new Movie(1, "World of warcraft"),
                new Movie(2, "A Bug's Life"),
                new Movie(3, "No county for old men"),
                new Movie(4, "Return to me"),
                new Movie(5, "Programmers")};
        shows = new Show[]{
                new Show(1, movies[0], "5:30pm", 100),
                new Show(2, movies[3], "7:00pm", 300),
                new Show(3, movies[1], "6:00pm", 200),
                new Show(4, movies[4], "9:00pm", 200)};
    }

    public synchronized Movie findMovieById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id)
                return movie;
        }
        return null;
    }

    public synchronized Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (Objects.equals(movie.getTitle(), title))
                return movie;
        }
        return null;
    }

    public synchronized Movie[] findAllMovies() {
        return movies;
    }

    public synchronized Show findShowById(int id) {
        for (Show show : shows) {
            if (show.getId() == id)
                return show;
        }
        return null;
    }

    public synchronized Show findShowByMovie(Movie movie) {
        for (Show show : shows) {
            if (show.getMovie().getId() == movie.getId())
                return show;
        }
        return null;
    }

    public synchronized Show[] findAllShows() {
        return shows;
    }
}