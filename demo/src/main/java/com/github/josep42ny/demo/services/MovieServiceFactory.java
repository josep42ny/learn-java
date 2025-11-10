package com.github.josep42ny.demo.services;

public class MovieServiceFactory {

    public static MovieService create() {
        return new MovieServiceOrmImpl();
    }

}
