package domain;

public class Movie {
    // attributes
    private String title;
    private String directedBy;
    private Integer runtime;
    
    // constructors
    public Movie(String title, String directedBy, int runtime) {
        this.title = title;
        this.directedBy = directedBy;
        this.runtime = runtime;
    }

    public Movie() {
    }
    
    // getters & setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    
    // utils
    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", directedBy=" + directedBy + ", runtime=" + runtime + '}';
    }   
    
}
