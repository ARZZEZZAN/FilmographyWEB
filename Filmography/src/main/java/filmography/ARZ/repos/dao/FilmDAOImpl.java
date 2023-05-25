package filmography.ARZ.repos.dao;

import filmography.ARZ.repos.Model.Film;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public FilmDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Film> allFilms() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> root = query.from(Film.class);

        query.select(root);
        TypedQuery<Film> typedQuery = session.createQuery(query);
        List<Film> films = typedQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return films;
    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.merge(film);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Film getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Film film = session.find(Film.class, id);
        session.getTransaction().commit();
        session.close();
        return film;
    }
}
