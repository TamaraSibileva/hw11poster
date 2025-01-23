package ru.netology.hw11poster.manager;

public class MovieManager {

    private MovieItem[] movies = new MovieItem[0];
//    private String[] movies = new String[0];
    private int limit;

    public MovieManager() {

        this.limit = 5;
    }

    public MovieManager(int limit) {

        this.limit = limit;
    }

    public void addMovie(MovieItem movie) {
        MovieItem[] tmp = new MovieItem[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieItem[] FindAll() {
        return movies;
    }

    public MovieItem[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        MovieItem[] tmp = new MovieItem[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }

}
