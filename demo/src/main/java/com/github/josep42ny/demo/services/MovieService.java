package com.github.josep42ny.demo.services;

import com.github.josep42ny.demo.model.Movie;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public interface MovieService {
    public List<Movie> getMovies();
    public Movie getById(long id);
    public boolean addMovie(Movie movie);
    public Movie deleteMovieById(long id);
}
