CREATE DATABASE IF NOT EXISTS secure_movie_library;

USE secure_movie_library;

create table if not exists movies
(
    movie_id           int auto_increment
        primary key,
    movie_title        varchar(200)  not null,
    movie_director     varchar(150)  null,
    movie_release_year int           null,
    movie_rating       decimal(3, 1) null
);