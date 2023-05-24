package filmography.ARZ.repos.dao;

import filmography.ARZ.repos.Model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class FilmDAOImpl implements FilmDAO{
    private static final AtomicLong AUTO_ID = new AtomicLong(1);
    private static Map<Long, Film> films = new HashMap<>();
    static {
        Film film = new Film();
        film.setId(AUTO_ID.getAndIncrement());
        film.setUrl("");
        film.setTitle("Начало");
        film.setWatched(true);
        film.setYear(2013);
        films.put(film.getId(), film);
    }
    @Override
    public List<Film> allFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public Film getById(Long id) {
        return films.get(id);
    }
}
