package cz.czechitas.java2webapps.ukol6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {

   @GetMapping("/")
    public ModelAndView seznam(){
        ModelAndView modelAndView = new ModelAndView("seznam");
        return modelAndView;
       }
}
