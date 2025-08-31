package org.cfs.Movies.Api.entity;

import java.time.LocalDate;
import java.time.Year;

public class MovieApi {
    private Long id;
    private String title;
    private String genre;
    private Year year;
    private String rating;


    public MovieApi() {
    }

    public MovieApi(Long id, String title, String genre, LocalDate year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = Year.from(year);
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = Year.from(year);
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
