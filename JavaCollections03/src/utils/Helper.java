package utils;

import domain.Student;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helper {

    static Scanner scanFor = new Scanner(System.in);
    static Random random = new Random();
    
    /**
     * handles the program whenever the user
     * decides not to add any more students to the list.
     * @param students list with all students registered.
     * @param text should display a message of your choice.
     * @param error message displayed if no students matches the search input.
     */
    public static void callItADay(ArrayList<Student> students, String text, String error) {
        print(students, text);
        String name = scanFor.nextLine();

        if (found(students, name)) {
            int[] grades = get(students, name, error).getGrades();
            print(grades, name);
            average(grades, name);
        } else {
            throw new Error(error);
        }
    }

    /**
     * this should set random grades
     * @return an array of three grades
     */
    public static int[] grades() {
        int[] grades = new int[3];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = random.nextInt(10);
        }

        return grades;
    }

    /**
     * @param grades from which should get the average grade
     * @param name of the student
     */
    static void average(int[] grades, String name) {
        int avg = 0;

        for (int i = 0; i < grades.length; i++) {
            avg = Integer.sum(avg, grades[i]);
        }
        
        avg /= grades.length;

        System.out.println("\nLa nota final de "
                + name + " es de de " + avg);
    }

    
    /**
     * @param students list with all students registered.
     * @param name of the student you're looking for.
     * @return true or false, depending on if it finds the student in the list or not.
     */
    private static boolean found(ArrayList<Student> students, String name) {
        return students.stream().anyMatch(
                        (s) -> (s.getName().equalsIgnoreCase(name))
        );
    }
    
    
    /**
     * should get a student searched for
     * in a list using its name.
     * @param students list with all students registered.
     * @param name of the student you need the grades from.
     * @param error message displayed if no students matches the search input.
     * @return Student found.
     * @throws an error if student isn't there.
     */
    private static Student get(ArrayList<Student> students, String name, String error) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new Error(error);
    }
    
    /**
     * prints a message according to parameters.
     * @param grades
     * @param name 
     */
    private static void print(int[] grades, String name) {
        System.out.println("Las notas de " + name + 
                " fueron: ");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i] + "\t");        
        }
    }
    
    /**
     * prints a message according to parameters.
     * @param students list.
     * @param text message of your choice.
     */
    private static void print(ArrayList<Student> students, String text) {
        System.out.println(text);
        students.forEach((s) -> System.out.println(s.getName()));
    }
}
