drop schema if exists Film cascade;
create schema if not exists Film;

CREATE TABLE Film.film (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(50) NOT NULL UNIQUE,
                           url VARCHAR(50) NOT NULL,
                           year INT NOT NULL,
                           watched BOOLEAN NOT NULL
);
