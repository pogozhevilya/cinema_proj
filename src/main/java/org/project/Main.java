package org.project;

import org.project.entity.Show;
import org.project.entity.Storage;

public class Main {
    static Storage storage = Storage.getInstance () ;

    public static void main ( String [] args ) {
        Show[] shows = storage.findAllShows () ;
        for ( int i = 0 ; i < shows.length; i++ ) {
            Show show = shows [ i ] ;
            System.out.println ( show ) ;
        }
    }
}
