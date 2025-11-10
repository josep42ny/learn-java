package com.github.josep42ny.demo.services;

import com.github.josep42ny.demo.model.Movie;
import com.github.josep42ny.demo.util.JdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceJdbcImpl implements MovieService {

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            Connection connection = JdbcConnector.connection();
            PreparedStatement statement = connection.prepareStatement("select * from movies;");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long movieId = resultSet.getLong("id");
                String movieTitle = resultSet.getString("title");
                String movieDescription = resultSet.getString("description");
                int movieYear = resultSet.getInt("year");

                movies.add(new Movie(movieId, movieTitle, movieDescription, movieYear));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

        return movies;
    }

    @Override
    public Movie getById(long id) {
        Movie movie;
        ResultSet resultSet = null;
        try {
            Connection connection = JdbcConnector.connection();
            PreparedStatement statement = connection.prepareStatement("select * from movies where id = ?;");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            resultSet.next();
            long movieId = resultSet.getLong("id");
            String movieTitle = resultSet.getString("title");
            String movieDescription = resultSet.getString("description");
            int movieYear = resultSet.getInt("year");

            movie = new Movie(movieId, movieTitle, movieDescription, movieYear);
            connection.close();
        } catch (SQLException e) {
            return null;
        }

        return movie;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return false;
//        try {
//            Connection connection = JdbcConnector.connection();
//            PreparedStatement statement = connection.prepareStatement("insert into movies(id, title, description, year) values ");
//            statement.setLong(1, id);
//            resultSet = statement.executeQuery();
//
//            resultSet.next();
//            long movieId = resultSet.getLong("id");
//            String movieTitle = resultSet.getString("title");
//            String movieDescription = resultSet.getString("description");
//            int movieYear = resultSet.getInt("year");
//
//            movie = new Movie(movieId, movieTitle, movieDescription, movieYear);
//            connection.close();
//        } catch (SQLException e) {
//            return null;
//        }
    }

    @Override
    public Movie deleteMovieById(long id) {
        return null;
    }
}
