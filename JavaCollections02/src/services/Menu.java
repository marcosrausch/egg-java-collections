package services;

import domain.Pound;
import java.util.ArrayList;
import java.util.Scanner;
import static utils.Constants.DELETE;
import static utils.Constants.EXIT;
import static utils.Constants.STATEMENT_START;
import static utils.Constants.THANKS;

public class Menu {

    static Scanner scanFor = new Scanner(System.in);

    public static void show() {
        System.out.println(STATEMENT_START);
        String option = scanFor.nextLine();
        handle(option);
    }

    private static void handle(String option) {
        Pound pound = new Pound();

        if (option.equalsIgnoreCase(EXIT)) {
            print(pound);
            System.out.println(THANKS);
        } else if (option.equalsIgnoreCase(DELETE)) {
            print(pound);
            Admin.delete(pound);
            print(Admin.sort(pound));
            System.out.println(THANKS);
        } else {
            add(option, pound.getBreeds());
            print(pound);
            show();
        }
    }

    public static void add(String option, ArrayList<String> breeds) {
        breeds.add(option);
    }
    
    private static void print(Pound pound) {
            if (pound.getBreeds().size() > 0) System.out.println(pound.getBreeds());
    }
    
}
