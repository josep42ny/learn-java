package com.github.josep42ny.demo.services;

import com.github.josep42ny.demo.model.Movie;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MovieServiceStaticImpl implements MovieService {

    private static List<Movie> movies;

    static {
        movies = List.of(
                new Movie(1L, "Inception", "A thief enters dreams to steal secrets.", 2010),
                new Movie(2L, "The Matrix", "A hacker discovers reality is a simulation.", 1999),
                new Movie(3L, "Interstellar", "Explorers travel through a wormhole in space.", 2014),
                new Movie(4L, "The Dark Knight", "Batman faces the Joker in Gotham City.", 2008),
                new Movie(5L, "Parasite", "A poor family infiltrates a wealthy household.", 2019),
                new Movie(6L, "Pulp Fiction", "Interwoven crime stories in Los Angeles.", 1994),
                new Movie(7L, "The Shawshank Redemption", "A man imprisoned for a crime he didn't commit.", 1994),
                new Movie(8L, "Fight Club", "An underground fight club forms with dark motives.", 1999),
                new Movie(9L, "Forrest Gump", "The life journey of a kind-hearted man.", 1994),
                new Movie(10L, "The Lord of the Rings: The Fellowship of the Ring", "A quest to destroy a powerful ring.", 2001),
                new Movie(11L, "Gladiator", "A betrayed general seeks revenge in Rome.", 2000),
                new Movie(12L, "Titanic", "A love story aboard a doomed ship.", 1997),
                new Movie(13L, "The Godfather", "The story of a powerful mafia family.", 1972),
                new Movie(14L, "Avatar", "A human explores an alien world on Pandora.", 2009),
                new Movie(15L, "The Avengers", "Earth’s mightiest heroes team up to save the world.", 2012)
        );
    }


    public List<Movie> getMovies() {
        return Collections.unmodifiableList(MovieServiceStaticImpl.movies);
    }

    public Movie getById(long id) {
        return MovieServiceStaticImpl.movies.stream().filter(movie -> Objects.equals(movie.getId(), id)).findFirst().orElse(null);
    }

    public boolean addMovie(Movie movie) {
        return MovieServiceStaticImpl.movies.add(movie);
    }

    public Movie deleteMovieById(long id) {
        Movie movie = getById(id);
        return MovieServiceStaticImpl.movies.remove(movie) ? movie : null;
    }

}
