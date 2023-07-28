package domain;

public class Student {
    // attributes
    private String name;
    private int[] grades;

    // constructors
    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }
    
    public Student() {}
    
    // setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

   

}
