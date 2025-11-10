package com.github.josep42ny.demo.services;

import com.github.josep42ny.demo.model.Movie;
import com.github.josep42ny.demo.util.ConnectionManager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MovieServiceOrmImpl implements MovieService {

    private final EntityManager entityManager;

    public MovieServiceOrmImpl() {
        this.entityManager = ConnectionManager.manager();
    }

    @Override
    public List<Movie> getMovies() {
        return entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
    }

    @Override
    public Movie getById(long id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public boolean addMovie(Movie movie) {
        entityManager.persist(movie);
        return true;
    }

    @Override
    public Movie deleteMovieById(long id) {
        return null;
    }
}
