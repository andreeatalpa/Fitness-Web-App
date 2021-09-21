package ro.fitnessApp.FitnessApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fitnessApp.FitnessApp.dao.Abonamente;
import ro.fitnessApp.FitnessApp.dao.AbonamenteDAO;

import java.util.List;

@Service
public class AbonamenteService {
    @Autowired
    AbonamenteDAO abonamenteDAO;

    public List<Abonamente> getallAbonamente() {
        return (List<Abonamente>) abonamenteDAO.findAll();
    }

    public String adaugaAbonamente(String name, Double price) {
        Abonamente abonamente = new Abonamente();
        abonamente.setName(name);
        abonamente.setPrice(price);
        abonamenteDAO.save(abonamente);
        return "Abonamentul " + abonamente.getName() + " a fost adaugat";
    }

    public Abonamente findById(int id){
        return abonamenteDAO.findById(id).get();
    }

    public String stergeAbonamente(Integer id){
        abonamenteDAO.deleteById(id);
        return "produsul a fost sters";
    }

}