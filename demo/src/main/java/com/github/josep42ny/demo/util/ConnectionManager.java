package com.github.josep42ny.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("moviesMysql");

    public static EntityManager manager() {
        return emf.createEntityManager();
    }

}
