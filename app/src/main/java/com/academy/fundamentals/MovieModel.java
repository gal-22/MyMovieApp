package com.academy.fundamentals;

public class MovieModel {
    private String movieName;
    private String overview;
    private String trailerUrl;
    private int imageResId;

    public MovieModel(String movieName, String overview, String trailerUrl, int imageResId) {
        this.movieName = movieName;
        this.overview = overview;
        this.trailerUrl = trailerUrl;
        this.imageResId = imageResId;
    }

    public MovieModel() {

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
