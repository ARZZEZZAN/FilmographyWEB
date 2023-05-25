drop schema if exists FilmData cascade;
create schema if not exists FilmData;

CREATE TABLE FilmData.film (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(50) NOT NULL UNIQUE,
                           url VARCHAR(50) NOT NULL,
                           year INT NOT NULL,
                           watched BOOLEAN NOT NULL
);
