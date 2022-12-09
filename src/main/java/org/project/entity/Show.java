package org.project.entity;

public class Show {
    int id;
    Movie movie;
    String showtime;
    int availableSeats;

    public Show ( int id, Movie movie, String showtime, int availableSeats ) {
        this .id = id;
        this .movie = movie;
        this .showtime = showtime;
        this .availableSeats = availableSeats;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this .id = id;
    }

    public Movie getMovie () {
        return movie;
    }

    public void setMovie ( Movie movie ) {
        this .movie = movie;
    }

    public String getShowtime () {
        return showtime;
    }

    public void setShowtime ( String showtime ) {
        this .showtime = showtime;
    }

    public int getAvailableSeats () {
        return availableSeats;
    }

    public void setAvailableSeats ( int availableSeats ) {
        this .availableSeats = availableSeats;
    }

    public String toString () {
        return "[" + id + "] " + movie + ", " + showtime + ", "
                + availableSeats;
    }
}