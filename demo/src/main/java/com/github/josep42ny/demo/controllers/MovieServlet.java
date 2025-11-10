package com.github.josep42ny.demo.controllers;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.github.josep42ny.demo.model.Movie;
import com.github.josep42ny.demo.services.MovieService;
import com.github.josep42ny.demo.services.MovieServiceFactory;
import com.github.josep42ny.demo.services.MovieServiceStaticImpl;
import com.github.josep42ny.demo.util.JdbcConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name    = "movieServlet", value = "/movies")
public class MovieServlet extends HttpServlet {

    private MovieService service;

    public void init() {
        this.service = MovieServiceFactory.create();
    }

    private void showAllMovies(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        List<Movie> movies = new ArrayList<>();

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

        request.setAttribute("movies", movies);
        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }

    private void showMovie(String rawId, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(rawId);
        } catch (NumberFormatException e) {
            id = -1L;
        }

        Movie movie = this.service.getById(id);
        request.setAttribute("movies", movie == null ? null : List.of(movie));

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String rawId = request.getParameter("id");

        if (rawId == null) {
            try {
                showAllMovies(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            showMovie(rawId, request, response);
        }
    }

    public void destroy() {
    }
}