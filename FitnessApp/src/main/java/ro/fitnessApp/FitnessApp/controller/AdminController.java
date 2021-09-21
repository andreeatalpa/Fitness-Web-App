package ro.fitnessApp.FitnessApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.fitnessApp.FitnessApp.dao.Abonamente;
import ro.fitnessApp.FitnessApp.service.AbonamenteService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AbonamenteService abonamenteService;

    @GetMapping("/admin/tarife")
    public ModelAndView veziAbonamente(){
        ModelAndView modelAndView =
                new ModelAndView("admin/tarife");
        List<Abonamente> abonamenteList = abonamenteService.getallAbonamente();
        modelAndView.addObject("abonamente", abonamenteList);
        return  modelAndView;
    }

    @PostMapping("/admin/tarife")
    @ResponseBody
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") Double price
    ){
        return abonamenteService.adaugaAbonamente(name, price);
    }

    @DeleteMapping("/admin/tarife/{id}")
    @ResponseBody
    public String removeProduct(@PathVariable("id") Integer id){
        return abonamenteService.stergeAbonamente(id);
    }

}

