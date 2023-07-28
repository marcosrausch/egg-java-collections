package services;

import domain.Student;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Helper;


public class College extends Constants {

    static Scanner scanFor = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    
    /**
     * Welcomes user
     * Adds the first student; this step is mandatory
     * Asks for another student
     * And handles the answer
     */
    public static void start() {
        System.out.println(WELCOME);
        students.add(register(scanFor.nextLine()));
        System.out.println(STATEMENT);
        handle(scanFor.nextLine(), students);
    }
    
    /**
     * this should actually create a student.
     * grades will be randomnly selected.
     * @param name it's the student's name.
     * @return Student
     */
    static Student register(String name) {
        return new Student(name, Helper.grades());
    };
    
    /**
     * either calls it a day or adds another student
     * @param option either a yes or a no
     * @throws an error whenever user's input
     * isn't a 'yes' or a not
     */
    static void handle(String option, ArrayList<Student> students) {
        if (option.equalsIgnoreCase(YES)) {
            start();
        } else if (option.equalsIgnoreCase(NO)) {
            Helper.callItADay(students, FINAL_GRADE, ERROR);
        } else {
            throw new Error(ERROR);
        }
    }
   
    
}
