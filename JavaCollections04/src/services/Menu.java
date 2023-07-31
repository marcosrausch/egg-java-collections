package services;

import domain.Movie;
import helpers.Constants;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Constants {

    static Scanner scanFor = new Scanner(System.in);

    /**
     * shows the menu and calls the option handler
     * @param movies stored on the list, needed by the handler
     */
    public static void start(ArrayList<Movie> movies) {
        show();
        handle(scanFor.nextInt(), movies);
    }

    /**
     * handles the cinema menu according by the
     * @param option chosen by the user regarding
     * @param movies provided as an argument.
     */
    static void handle(int option, ArrayList<Movie> movies) {
        switch (option) {
            case 1:
                Cinema.showMovies(movies);
                break;
            case 2:
                Cinema.showMovies(movies, true);
                break;
            case 3:
                Cinema.sortMovies(movies, Order.DESC);
                break;
            case 4:                
                Cinema.sortMovies(movies, Order.ASC);    
                break;
            case 5:
                Cinema.sortMovies(movies, SORT_BY_TITLE);
                break;
            case 6:
                Cinema.sortMovies(movies, SORT_BY_DIRECTOR);
                break;
            case 7:
                System.out.println(GOODBYE);
                break;
            default:
                throw new Error(ERROR);
        }
        if (option != EXIT) start(movies);
    }
    
    /**
     * It prints the menu on terminal.
     */
    static void show() {
        System.out.println(MENU);
    }
}
