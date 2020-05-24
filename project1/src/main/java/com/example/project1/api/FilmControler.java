package com.example.project1.api;

import com.example.project1.accessToData.FilmWrite;
import com.example.project1.accessToData.table.Film;
import com.example.project1.manager.FilmManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class FilmControler {

    private final FilmManager filmManager;

    public FilmControler(FilmManager filmManager) {
        this.filmManager = filmManager;
    }

    @GetMapping
    String showFilms(Model model){
        model.addAttribute("project",new FilmWrite());
        return "projects";
    }

    @PostMapping
    String addFilm(@ModelAttribute ("project") Film filmWrite, Model model){
        filmManager.save(filmWrite);
        model.addAttribute("project",new Film());
        model.addAttribute("message","Dodano film");
        return "projects";
    }
}
