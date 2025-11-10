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

@WebServlet(name = "movieServlet", value = "/movies")
public class MovieServlet extends HttpServlet {

    private MovieService service;

    public void init() {
        this.service = MovieServiceFactory.create();
    }

    private void showAllMovies(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("movies", service.getMovies());
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
            showAllMovies(request, response);
        } else {
            showMovie(rawId, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.addMovie(new Movie(
                0L,
                req.getParameter("title"),
                req.getParameter("body"),
                Integer.parseInt(req.getParameter("year"))
        ));
    }

    public void destroy() {
    }
}