package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkaController {
    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("seznamOsob", vizitkaRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id) {
        Optional<Vizitka> vizitka = vizitkaRepository.findById(id);
        if (vizitka.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ModelAndView("vizitka")
                .addObject("osoba", vizitka.get());
    }

    @GetMapping("/nova")
    public ModelAndView novaVizitka() {
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("osoba", new Vizitka());
        return modelAndView;
    }

    @PostMapping("/nova")
    public String pridatVizitku(@Valid @ModelAttribute("osoba") Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String smazatVizitku(@PathVariable Integer id) {
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/{id:[0-9]+}/edit")
    public Object editaceVizitky(@PathVariable Integer id) {
        Optional<Vizitka> vizitka = vizitkaRepository.findById(id);
        if (vizitka.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("osoba", vizitka.get());
        return modelAndView;
    }

    @PostMapping("/{id:[0-9]+}/edit")
    public Object ulozitZmenuVizitky(@Valid @ModelAttribute("osoba") Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/{id}";
    }

}