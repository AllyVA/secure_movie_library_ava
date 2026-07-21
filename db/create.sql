CREATE DATABASE IF NOT EXISTS secure_movie_library;

USE secure_movie_library;

create table movies
(
    movie_id           int auto_increment
        primary key,
    movie_title        varchar(200) not null,
    movie_director     varchar(150) null,
    movie_release_year int          null,
    movie_rating       double(3, 1) null,
    constraint chk_movie_rating
        check (`movie_rating` is null or `movie_rating` between 0.0 and 10.0)
);