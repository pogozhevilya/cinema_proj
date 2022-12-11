package org.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.entity.Show;
import org.project.entity.Storage;

import java.io.File;
import java.io.IOException;

public class Main {
    static Storage storage = Storage.getInstance () ;

    public static void main ( String [] args ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "./dbJson.json";
        Show[] shows = storage.findAllShows () ;
        for (Show show : shows) {
            System.out.println(show);
        }
        objectMapper.writeValue(new File(filePath), shows);
    }
}
