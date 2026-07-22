package com.telerikacademy.web.securemovielibrary.repositories;


import com.telerikacademy.web.securemovielibrary.exceptions.MovieNotFoundException;
import com.telerikacademy.web.securemovielibrary.models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public MovieRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Movie> get() {
        try (Session session = sessionFactory.openSession()) {
            Query<Movie> query = session.createQuery(
                    "from Movie m order by m.movieRating desc ",
                    Movie.class
            );
            return query.list();
        }
    }

    @Override
    public Movie get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Movie movie = session.find(Movie.class, id);

            if (movie == null) {
                throw new MovieNotFoundException("Movie");
            }
            return movie;
        }
    }

    @Override
    public List<Movie> search(String keyword) {
        try (Session session = sessionFactory.openSession()) {

            Query<Movie> query = session.createQuery(
                    "from Movie m " +
                            "where lower(m.movieTitle) like lower(:keyword) " +
                            "order by m.movieRating desc",
                    Movie.class
            );

            query.setParameter("keyword", "%" + keyword + "%");

            return query.list();
        }
    }

    @Override
    public void create(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(movie);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(movie);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        Movie movieToDelete = get(id);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(session.merge(movieToDelete));
            session.getTransaction().commit();
        }
    }
}
