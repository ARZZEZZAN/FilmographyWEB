package filmography.ARZ.repos.service;

import filmography.ARZ.repos.Model.Film;
import filmography.ARZ.repos.dao.FilmDAO;
import filmography.ARZ.repos.dao.FilmDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmDAO filmDAO;

    @Autowired
    public FilmServiceImpl(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Override
    @Transactional
    public List<Film> allFilms() {
        return filmDAO.allFilms();
    }

    @Override
    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Override
    @Transactional
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Override
    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Override
    @Transactional
    public Film getById(Long id) {
        return filmDAO.getById(id);
    }
}
