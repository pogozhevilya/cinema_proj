package org.project.entity;

public class Storage {
    private static Storage ourInstance;
    private final Movie [] movies;
    private final Show [] shows;

    public synchronized static Storage getInstance () {
        if ( ourInstance == null ) {
            ourInstance = new Storage () ;
        }
        return ourInstance;
    }

    private Storage () {
        movies = new Movie [] { new Movie ( 1 , "Return of the JNDI" ) ,
                new Movie ( 2 , "A Bug's Life" ) , new Movie ( 3 , "Fatal Exception" ) ,
                new Movie ( 4 , "Silence of the LANs" ) ,
                new Movie ( 5 , "Object of my Affection" ) } ;
        shows = new Show [] { new Show ( 1 , movies [ 0 ] , "5:30pm" , 100 ) ,
                new Show ( 2 , movies [ 0 ] , "7:00pm" , 300 ) ,
                new Show ( 3 , movies [ 1 ] , "6:00pm" , 200 ) ,
                new Show ( 4 , movies [ 4 ] , "9:00pm" , 200 ) } ;
    }

    public synchronized Movie findMovieById ( int id ) {
        for ( int i = 0 ; i < movies.length; i++ ) {
            Movie movie = movies [ i ] ;
            if ( movie.id == id )
                return movie;
        }
        return null ;
    }

    public synchronized Movie findMovieByTitle ( String title ) {
        for ( int i = 0 ; i < movies.length; i++ ) {
            Movie movie = movies [ i ] ;
            if ( movie.title == title )
                return movie;
        }
        return null ;
    }

    public synchronized Movie [] findAllMovies () {
        return movies;
    }

    public synchronized Show findShowById ( int id ) {
        for ( int i = 0 ; i < shows.length; i++ ) {
            Show show = shows [ i ] ;
            if ( show.id == id )
                return show;
        }
        return null ;
    }

    public synchronized Show findShowByMovie ( Movie movie ) {
        for ( int i = 0 ; i < shows.length; i++ ) {
            Show show = shows [ i ] ;
            if ( show.movie.id == movie.id )
                return show;
        }
        return null ;
    }

    public synchronized Show [] findAllShows () {
        return shows;
    }
}