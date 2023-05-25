package filmography.ARZ.repos.controller;

import filmography.ARZ.repos.Model.Film;
import filmography.ARZ.repos.service.FilmService;
import filmography.ARZ.repos.service.FilmServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService service = new FilmServiceImpl();
    @GetMapping("/")
    public ModelAndView allFilms() {
        List<Film> filmList = service.allFilms();
        ModelAndView modelAndView = new ModelAndView("film");
        modelAndView.addObject("filmList", filmList);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        service.edit(film);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editPage");
        Film film = service.getById(id);
        modelAndView.addObject("film", film);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView("editPage");
        modelAndView.addObject("film", new Film());
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        service.add(film);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        Film film = service.getById(id);
        service.delete(film);
        return modelAndView;
    }
}
