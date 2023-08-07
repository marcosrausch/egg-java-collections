package services;

import static helpers.Constants.ERROR;
import static helpers.Constants.NO;
import static helpers.Constants.YES;
import static helpers.Dialogue.ADD_ANOTHER_COUNTRY;
import static helpers.Dialogue.ADD_COUNTRY;
import static helpers.Dialogue.DISCLAIMER;
import static helpers.Dialogue.REMOVE_COUNTRY;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class World {

    static TreeSet<String> countries = new TreeSet<String>();
    static Scanner scanFor = new Scanner(System.in);

    /**
     * Adds a country to the Set and asks if
     * the user wants to add another one
     * Then it calls the handler
     */
    public static void start() {
        addCountry();

        System.out.println(ADD_ANOTHER_COUNTRY);
        handle(scanFor.nextLine());
    }

    /**
     * Adds a country to the set provided by the user
     */
    static void addCountry() {
        System.out.println(ADD_COUNTRY);
        countries.add(scanFor.nextLine());
    }

    /**
     * prints the countries alphabetically
     */
    static void showCountries() {
        Iterator it = countries.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * asks the user for a country and, if found,
     * removes it from the Set.
     * If the country is not found, shows a disclaimer
     */
    static void removeCountry() {
        System.out.println(REMOVE_COUNTRY);
        String input = scanFor.nextLine();
        
        if (countries.contains(input)) {
            countries.remove(input);
            showCountries();
        } else {
            System.out.println(DISCLAIMER);
        }
    }

    /**
     * If the users input is 's', calls start() method
     * to add another country,
     * if the users input is 'n', shows the countries Set
     * and calls to removeCountry()
     * @param option either a yes or a no.
     * @return an error whenever the input isn't an 's' or an 'n'
     */
    static void handle(String option) {
        if (option.equalsIgnoreCase(YES)) {
            start();
        } else if (option.equalsIgnoreCase(NO)) {
            showCountries();
            removeCountry();
        } else {
            throw new Error(ERROR);
        }
    }

}
