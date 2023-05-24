package filmography.ARZ.repos.service;

import filmography.ARZ.repos.Model.Film;

import java.util.List;

public interface FilmService {
    List<Film> allFilms();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(Long id);
}
