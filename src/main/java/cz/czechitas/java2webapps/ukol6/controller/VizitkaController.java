package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {
    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    @GetMapping("/")
    public ModelAndView seznam(){
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("seznamOsob", vizitkaRepository.findAll());
        return modelAndView;
       }
}
