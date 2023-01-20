package org.project.entity;

public class Show extends AbstractEntity<Integer> {
    private Integer id;
    private Movie movie;
    private String showtime;
    private int availableSeats;

    public Show(Integer id, Movie movie, String showtime, int availableSeats) {
        this.id = id;
        this.movie = movie;
        this.showtime = showtime;
        this.availableSeats = availableSeats;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String toString() {
        return "[" + id + "] " + movie + ", " + showtime + ", "
                + availableSeats;
    }
}