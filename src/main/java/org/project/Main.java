package org.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.entity.Show;
import org.project.entity.Storage;

import java.util.Arrays;
import java.util.Scanner;
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

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Функциональщина:\n1- Найти название фильма по id,  2- показ по названию, 3 - показ по id, 4- Вывести все фильмы в прокате\n");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Введите id фильма ");
                    int id_film = in.nextInt();
                    System.out.println(Storage.getInstance().findMovieById(id_film));
                }
                case 2 -> {
                    System.out.println("Введите название фильма ");
                    String title_film = in.nextLine();
                    System.out.println(Storage.getInstance().findMovieByTitle(title_film));

                }
                case 3 -> {
                    System.out.println("Введите id фильма ");
                    int id_show = in.nextInt();
                    System.out.println(Storage.getInstance().findShowById(id_show));
                }
                case 4 -> System.out.println(Arrays.toString(Storage.getInstance().findAllMovies()));
            }
        }
    }
}
