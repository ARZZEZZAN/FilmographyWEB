package filmography.ARZ.repos.controller;

import filmography.ARZ.repos.Model.Film;
import filmography.ARZ.repos.service.FilmService;
import filmography.ARZ.repos.service.FilmServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService service = new FilmServiceImpl();
    @GetMapping("/")
    public String allFilms(Model model) {
        List<Film> filmList = service.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("filmList", filmList);
        return "film";
    }
    @GetMapping("/edit")
    public String editPage(Model model) {
        return "editPage";
    }
    @GetMapping("/add")
    public String addPage(Model model) {
        return "add";
    }
}
