package services;

import domain.Movie;
import java.util.Comparator;

public class Compare {

    public static Comparator<Movie> byRuntime = new Comparator<Movie>() {
        @Override
        public int compare(Movie m, Movie m1) {
            return m.getRuntime().compareTo(m1.getRuntime());
        }
    };
    
    public static Comparator<Movie> byDirector = new Comparator<Movie>() {
        @Override
        public int compare(Movie m, Movie m1) {
            return m.getDirectedBy().compareToIgnoreCase(m1.getDirectedBy());
        }
    };

    public static Comparator<Movie> byTitle = new Comparator<Movie>() {
        @Override
        public int compare(Movie m, Movie m1) {
            return m.getTitle().compareToIgnoreCase(m1.getTitle());
        }
    };
}

