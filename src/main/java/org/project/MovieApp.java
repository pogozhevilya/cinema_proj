package org.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.entity.Show;
import org.project.repository.MovieRepository;
import org.project.repository.ShowRepository;
import org.project.repository.impl.MovieRepositoryImpl;
import org.project.repository.impl.ShowRepositoryImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieApp {
    private static final MovieRepository MOVIE_REPOSITORY = MovieRepositoryImpl.getInstance();
    private static final ShowRepository SHOW_REPOSITORY = ShowRepositoryImpl.getInstance();

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "./dbJson.json";
        List<Show> shows = SHOW_REPOSITORY.findAllShows();
        shows.forEach(System.out::println);
        objectMapper.writeValue(new File(filePath), shows);
        disp();
    }

    private static void disp() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Функциональщина:\n1- Найти название фильма по id,  2- показ по названию, 3 - показ по id, 4- Вывести все фильмы в прокате\n");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите id фильма ");
                    int idFilm = in.nextInt();
                    System.out.println(MOVIE_REPOSITORY.findMovieById(idFilm));
                }
                case 2 -> {
                    System.out.println("Введите название фильма ");
                    String titleFilm = in.nextLine();
                    System.out.println(MOVIE_REPOSITORY.findMovieByTitle(titleFilm));
                }
                case 3 -> {
                    System.out.println("Введите id фильма ");
                    int idShow = in.nextInt();
                    System.out.println(SHOW_REPOSITORY.findShowById(idShow));
                }
                case 4 -> System.out.println(MOVIE_REPOSITORY.findAllMovies());
            }
        }
    }
}
