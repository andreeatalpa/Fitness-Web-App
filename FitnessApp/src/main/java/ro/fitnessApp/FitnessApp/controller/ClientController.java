package ro.fitnessApp.FitnessApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.fitnessApp.FitnessApp.dao.*;
import ro.fitnessApp.FitnessApp.exceptions.UserException;
import ro.fitnessApp.FitnessApp.security.ClientSession;
import ro.fitnessApp.FitnessApp.service.AbonamenteService;
import ro.fitnessApp.FitnessApp.service.ClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    ClientSession clientSession;

    @Autowired
    AbonamenteService abonamenteService;

    @Autowired
    ComenziDAO comenziDAO;

    List<Abonamente> abonamente = new ArrayList<Abonamente>();

    HashMap<Integer,Integer> servicii = new HashMap<Integer,Integer>()
    {{
        put(0,210);
        put(1,179);
        put(2,35 );
    }};

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ModelAndView registerAction(@RequestParam("email") String email,
                                       @RequestParam("password") String password,
                                       @RequestParam("password-again") String password2,
                                       @RequestParam("name") String name) {
        if(email.isEmpty() ||
                password.isEmpty() ||
                password2.isEmpty() ||
                name.isEmpty() ||
                !password.equals(password2))
        {
            return new ModelAndView("eroare");
        }

        List<Client> clienti = clientService.getUserByEmail(email);
        if (clienti.size() > 0 ) {
            return new ModelAndView("eroare");
        }

        try {
            clientService.checkPassword(password, password2);
            clientService.save(email, password, name);

            return new ModelAndView("index");
        } catch (UserException e) {
            return new ModelAndView("eroare");
        }
    }

    @RequestMapping(value = "/contulMeu", method = {RequestMethod.POST})
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String parola) {
        if(email.isEmpty() || parola.isEmpty())
        {
            return new ModelAndView("eroare");
        }

        List<Client> clients = clientService.getUserByEmail(email);
        if (clients.size() == 0) {
            return new ModelAndView("register");
        }

        Client client = clients.get(0);
        if(!client.getParola().equals(parola))
        {
            return new ModelAndView("eroare");
        }

        clientSession.setId(client.getId());
        return new ModelAndView("autentificare");
    }

    @RequestMapping(value = "/cosCumparaturi", method = {RequestMethod.POST})
    public ModelAndView adaugaInCos(@RequestParam("abonamentId") Integer id) {
        if (clientSession.getId() == -1) {
            return new ModelAndView("contulMeu");
        }

        if( !servicii.containsKey(id))
        {
            return new ModelAndView("/admin/tarife");
        }

        Abonamente abonament = new Abonamente();
        abonament.setId(id);
        abonament.setPrice(servicii.get(id).intValue());
        abonamente.add(abonament);

        return cosCumparaturiview();
    }

    @GetMapping("/cumpara")
    public ModelAndView modelAndView() {
        abonamente.clear();
        ModelAndView modelAndView = new ModelAndView("succes");
        return modelAndView;
    }

    @GetMapping("/program")
    public ModelAndView programview() {
        ModelAndView modelAndView = new ModelAndView("program");
        return modelAndView;
    }
    @GetMapping("/despre")
    public ModelAndView despreview() {
        ModelAndView modelAndView = new ModelAndView("despre");
        return modelAndView;
    }
    @GetMapping("/tarife")
    public ModelAndView tarifeview() {
        ModelAndView modelAndView = new ModelAndView("/admin/tarife");
        return modelAndView;
    }
    @GetMapping("/index")
    public ModelAndView indexview() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @GetMapping("/contact")
    public ModelAndView contactview() {
        ModelAndView modelAndView = new ModelAndView("contact");
        return modelAndView;
    }

    @RequestMapping(value = "/cosCumparaturi", method = {RequestMethod.GET})
    public ModelAndView cosCumparaturiview() {
        ModelAndView modelAndView = new ModelAndView("cosCumparaturi");
        List<CosCumparaturi> produseCos = new ArrayList<>();
        double valoareTotalaCos = 0;
        for(Abonamente abonament: abonamente)
        {
            valoareTotalaCos += abonament.getPrice();
        }

        modelAndView.addObject("valoareTotala", valoareTotalaCos);
        return modelAndView;
    }
    @RequestMapping(value = "/contulMeu", method = {RequestMethod.GET})
    public ModelAndView contulMeuView() {
        if(clientSession.getId() != -1)
        {
            return new ModelAndView("autentificare");
        }
        ModelAndView modelAndView = new ModelAndView("contulMeu");
        return modelAndView;
    }
    @GetMapping("/succes")
    public ModelAndView succesview() {
        ModelAndView modelAndView = new ModelAndView("succes");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = {RequestMethod.GET})
    public ModelAndView registerview() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }
}
