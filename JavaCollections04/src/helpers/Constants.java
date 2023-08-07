package helpers;

public class Constants {

    protected static final String TITLE
            = "Por favor, ingrese el título de la película";

    protected static final String DIRECTOR
            = "Por favor, indique el director de la película";

    protected static final String RUNTIME
            = "Por favor, ingrese en minutos la duración de la película";

    protected static final String ANOTHER_MOVIE
            = "¿Desea agregar otra película?";
    
    protected static final String RUNTIME_DISCLAIMER
            = "Ninguna de las películas disponibles "
            + "dura más de una hora";
    
    protected static final String YES
            = "S";

    protected static final String NO
            = "N";
    
    protected static final int EXIT
            = 7;
    
    protected static final int AN_HOUR
            = 60;
    
    protected static final String NEW_LINE
            = "\n";

    protected static final String ERROR
            = "Wrong option";

    protected static final String GOODBYE
            = "¡Adiós!";
    
    protected static final String SORT_BY_TITLE
            = "title";
       
    protected static final String SORT_BY_DIRECTOR
            = "director";
    
    protected static final String SORT_BY_RUNTIME
            = "runtime";  
        
    protected static final String MENU
            = "\n¿Qué desea hacer ahora?\n"
            + "1. Ver películas\n"
            + "2. Ver películas que duran más de una hora\n"
            + "3. Ver películas ordenadas de la más larga a la más corta\n"
            + "4. Ver películas ordenadas de la más corta a la más larga\n"
            + "5. Ver películas ordenadas alfabéticamente por título\n"
            + "6. Ver películas ordenadas alfabéticamente por director\n"
            + "7. Salir\n";
        
    public static enum Sort {
        ASC,
        DESC
    }
    
}
