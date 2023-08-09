package services;

import static helpers.Constants.CITIES_TO_ADD;
import static helpers.Constants.CITIES_TO_DELETE;
import static helpers.Constants.KEY_NOT_FOUND;
import static helpers.Dialogue.ASK_CITY_NAME;
import static helpers.Dialogue.ASK_ZIP_CODE;
import static helpers.Dialogue.CITIES;
import static helpers.Dialogue.ZIP_CODE;
import java.util.HashMap;
import java.util.Scanner;

public class Postal {

    static Scanner scanFor;
    static HashMap<Integer, String> zipCodes = new HashMap<>();

    /**
     * starts the program
     * adds ten cities to map asking by terminal on zip codes and city names input
     * shows a city by asking zip code via terminal
     * Ask three times for city deletion
     * show the map data
     */
    public static void start() {
        for (int i = 0; i < CITIES_TO_ADD; i++) {
            System.out.print(i + 1 + ". ");
            addZipCodes();
        }
        showZipCodes();
        showCity();
        deleteCities();
        showZipCodes();
    }

    /**
     * asks for a zip code and a city name
     * adds both values to a map
     */
    static void addZipCodes() {
        scanFor = new Scanner(System.in).useDelimiter("\n");

        System.out.println(ZIP_CODE);
        Integer zipCode = scanFor.nextInt();

        System.out.println(CITIES);
        String city = scanFor.next();

        input(zipCode, city);
    }

    /**
     * adds key and value to every element in the map
     * @param key is the zip code
     * @param value is the city name assigned to that zip code
     */
    static void input(Integer key, String value) {
        zipCodes.put(key, value);
    }

    /**
     * prints out by terminal the map
     */
    static void showZipCodes() {
        zipCodes.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        });
    }

    /**
     * asks for a zip code and prints out
     * the city name assigned to it
     */
    static void showCity() {
        scanFor = new Scanner(System.in);

        System.out.println(ASK_ZIP_CODE);
        Integer input = scanFor.nextInt();

        if (zipCodes.containsKey(input)) {
            String city = zipCodes.get(input);
            System.out.println(city);
        } else {
            System.out.println(KEY_NOT_FOUND);
        }

    }

    /**
     * calls a seek and destroy method
     */
    static void deleteCities() {
        for (int i = 0; i < CITIES_TO_DELETE; i++) {
            System.out.print(i + 1 + ". ");
            seekAndDestroy();
        }
    }

    /**
     * asks for three city names and removes the entire element from the map
     */
    static void seekAndDestroy() {
        scanFor = new Scanner(System.in).useDelimiter("\n");

        System.out.println(ASK_CITY_NAME);
        String input = scanFor.nextLine();

        zipCodes.values().remove(input);
    }

}
