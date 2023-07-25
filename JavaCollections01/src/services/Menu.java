package services;

import domain.Pound;
import java.util.Scanner;

public class Menu {

    private static final String WELCOME
            = "¡Hola!";
    private static final String STATEMENT
            = "Agregue una raza a la lista o escriba salir";
    private static final String THANKS
            = "¡Gracias!";
    private static final String EXIT
            = "salir";

    static Scanner scanFor = new Scanner(System.in);

    public static void start() {
        Pound pound = new Pound();
        String option;

        System.out.println(WELCOME);

        while (true) {
            System.out.println(STATEMENT);
            option = scanFor.next();
            if (option.toLowerCase().equals(EXIT)) {
                break;
            }
            pound.getBreeds().add(option);
            System.out.println(THANKS);
        }

        System.out.println(pound.getBreeds());
    }

}
