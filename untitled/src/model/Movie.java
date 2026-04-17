package model;

public class Movie {

    private String title;
    private String generes;
    private int duration;

    public Movie(String title, String genres, int duration) {
        this.title = title;
        this.generes = genres;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return generes;
    }

    public void setGenres(String genres) {
        generes = genres;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void showMovies(){
        System.out.println("Película " + title + " | Duración: " + duration + " | Genere: " + generes);
    }
}
