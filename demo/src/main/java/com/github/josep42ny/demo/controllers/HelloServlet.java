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

        String rawId = request.getParameter("id");

        if (rawId == null) {
            request.setAttribute("movies", movies);
        } else {
            int id;
            try {
                id = Integer.parseInt(rawId);
            } catch (NumberFormatException e) {
                id = -1;
            }

            int finalId = id;
            boolean idFound = movies.stream().anyMatch(m->m.getId() == finalId);
            if (idFound) {
                Movie movie = movies.stream().filter(m->m.getId() == finalId).findFirst().get();
                List<Movie> movie1 = List.of(movie);
                request.setAttribute("movies", movie1);
            } else {
                request.setAttribute("movies", null);
            }
        }

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }

    public void destroy() {
    }
}