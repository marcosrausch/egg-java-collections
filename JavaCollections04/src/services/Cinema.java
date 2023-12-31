package services;

import domain.Movie;
import helpers.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cinema extends Constants {

    static ArrayList<Movie> movies = new ArrayList<>();
    static Scanner scanFor;

    public static void start() {
        createMovie();
    }

    /**
     * Asks for movie data Adds movie to movie list Asks for another movie Calls
     * the handler
     */
    public static void createMovie() {
        scanFor = new Scanner(System.in);

        System.out.println(TITLE);
        String title = scanFor.nextLine();

        System.out.println(DIRECTOR);
        String director = scanFor.nextLine();

        System.out.println(RUNTIME);
        int runtime = scanFor.nextInt();

        movies.add(register(title, director, runtime));

        System.out.println(ANOTHER_MOVIE);
        handle(scanFor.next(), movies);
    }

    /**
     * either creates another movie or shows the menu
     *
     * @param option either a yes or a no
     * @param movies stored in the list
     * @throws an error whenever user's input isn't a yes or a no
     */
    static void handle(String option, ArrayList<Movie> movies) {
        if (option.equalsIgnoreCase(YES)) {
            createMovie();
        } else if (option.equalsIgnoreCase(NO)) {
            Menu.start(movies);
        } else {
            throw new Error(ERROR);
        }
    }

    /**
     * prints on terminal the
     *
     * @param movies stored on the list.
     */
    static void showMovies(ArrayList<Movie> movies) {
        movies.forEach((m) -> {
            System.out.println(m.toString());
        });
    }

    /**
     * prints on terminal any
     *
     * @param movie which
     * @param runtime it's greater than 60 minutes.
     */
    static void showMovies(ArrayList<Movie> movie, boolean runtime) {
        if (runtime) {
            movies.forEach((Movie m) -> {
                if (m.getRuntime() > AN_HOUR) {
                    System.out.println(m.toString());
                }
            });
        } else {
            System.out.println(RUNTIME_DISCLAIMER);
        }
    }

    /**
     * It's like a movie constructor, in order to work needs the
     *
     * @param title of the movie
     * @param director or directors of the movie and
     * @param runtime of the movie
     * @return a new Movie each time is called.
     */
    static Movie register(String title, String director, int runtime) {
        return new Movie(title, director, runtime);
    }

    /**
     * It sorts the movie list according to arguments.
     * It shows it at the end.
     * @param movies is the list of movies
     * @param sort can be ascending or descending.
     */
    static void sortMovies(ArrayList<Movie> movies, String arg, Sort sort) {
        if (arg.equalsIgnoreCase("runtime")) {
            if (sort.equals(Sort.ASC)) {
                Collections.sort(movies, Compare.byRuntime.reversed());
            } else {
                Collections.sort(movies, Compare.byRuntime);
            }
        }
        
        if (arg.equalsIgnoreCase("director")) {
            Collections.sort(movies, Compare.byDirector);
        }
        
        if (arg.equalsIgnoreCase("title")) {
            Collections.sort(movies, Compare.byTitle);
        }

        showMovies(movies);
    }
    
}
