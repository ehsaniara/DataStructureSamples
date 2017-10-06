package com.ehsaniara.dataStructureSample.Test;

import java.util.*;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/21/17.
 * From http://www.ehsaniara.com
 */
public class Solution {

    public static void main(String[] args) {

        Movie movie1 = new Movie(1, 1.2F);
        Movie movie2 = new Movie(2, 3.6F);
        Movie movie3 = new Movie(3, 2.4F);
        Movie movie4 = new Movie(4, 4.8F);

        movie1.addSimilarMovies(movie2);
        movie1.addSimilarMovies(movie3);
        movie1.addSimilarMovies(movie4);


        movie2.addSimilarMovies(movie1);
        movie2.addSimilarMovies(movie3);
        movie2.addSimilarMovies(movie4);


        movie3.addSimilarMovies(movie1);
        movie3.addSimilarMovies(movie2);
        movie3.addSimilarMovies(movie4);


        System.out.println(new Solution().getMovieRecommendations(movie1, 2));
    }

    public Set<Movie> getMovieRecommendations(Movie movie, int N) {
        // WRITE YOUR CODE HERE

        List<Movie> similarMovies = movie.getSimilarMovies();

        Collections.sort(similarMovies, (p1, p2) -> (int) ((int) p2.getRating() - p1.getRating()));

        //to get last N movies
        Set<Movie> movieSet = new HashSet<>();
        for (int i = 0; i < similarMovies.size() && i < N; i++) {
            System.out.println(similarMovies.get(i).getId() + "->" + similarMovies.get(i).getRating());
            movieSet.add(similarMovies.get(i));
        }

        return movieSet;
    }

}

class Movie {
    private int movieId;
    private float rating;
    private ArrayList<Movie> similarMovies = new ArrayList<>();

    public Movie(int moveId, float rating) {
        this.movieId = moveId;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public int getId() {
        return movieId;
    }

    List<Movie> getSimilarMovies() {
        return similarMovies;
    }

    void addSimilarMovies(Movie movie) {
        this.similarMovies.add(movie);
    }
}
