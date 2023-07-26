package services;

import domain.Pound;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import static utils.Constants.DISCLOSURE_DELETE;
import static utils.Constants.EMPTY_LIST;
import static utils.Constants.STATEMENT_DELETE;

public class Admin {

    static Scanner scanFor = new Scanner(System.in);
        
    public static void start() {
        Menu.show();
    }
    
    public static void delete(Pound pound) {        
        if (pound.getBreeds().isEmpty()) {
            System.out.println(EMPTY_LIST);
            return;
        }
       
        Iterator breeds = pound.getBreeds().iterator();
        System.out.println(STATEMENT_DELETE);
        System.out.println(DISCLOSURE_DELETE);
        String name = scanFor.nextLine();
        
        while (breeds.hasNext()) {
            if (breeds.next().equals(name)) breeds.remove();
        }
    }
    
    public static Pound sort(Pound pound) {        
        Collections.sort(pound.getBreeds());
        return pound;
    }
    
}
