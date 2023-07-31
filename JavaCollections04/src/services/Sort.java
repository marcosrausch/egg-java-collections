package services;

import domain.Movie;
import helpers.Constants.Order;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    public static ArrayList<Movie> runtime(ArrayList<Movie> movies, Order order) {
        if (order.equals(Order.DESC)) {
            Collections.sort(movies,
                    (Movie m, Movie n) -> n.getRuntime() - m.getRuntime());
        } else {
            Collections.sort(movies,
                    (Movie m, Movie n) -> m.getRuntime() - n.getRuntime());
        }

        return movies;
    }
    
    public static ArrayList<Movie> title(ArrayList<Movie> movies) {
        Collections.sort(movies,
                (Movie m, Movie n) -> m.getTitle().compareTo(n.getTitle()));
        return movies;
    }
    
    public static ArrayList<Movie> directedBy(ArrayList<Movie> movies) {
        Collections.sort(movies,
                (Movie m, Movie n) -> m.getDirectedBy().compareTo(n.getDirectedBy()));
        return movies;
    }

}
