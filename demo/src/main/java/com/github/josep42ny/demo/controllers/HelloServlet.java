package com.github.josep42ny.demo.controllers;

import java.io.*;
import java.util.List;

import com.github.josep42ny.demo.model.Movie;
import com.github.josep42ny.demo.services.MovieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/movies")
public class HelloServlet extends HttpServlet {
    private List<Movie> movies;

    public void init() {
        this.movies = MovieService.getMovies();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String rawId = request.getParameter("name");

        request.setAttribute("movies", movies);

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }

    public void destroy() {
    }
}