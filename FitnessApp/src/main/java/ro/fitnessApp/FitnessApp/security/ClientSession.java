package ro.fitnessApp.FitnessApp.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@SessionScope
@Component
public class ClientSession {
    private int id = -1;
    private HashMap<Integer, Integer> cosCumparaturi = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public HashMap<Integer, Integer> getCosCumparaturi() {
        return cosCumparaturi;
    }

    public void setCosCumparaturi(HashMap<Integer, Integer> cosCumparaturi) {
        this.cosCumparaturi = cosCumparaturi;
    }

    public void adaugaInCos(int id) {
        if (cosCumparaturi.get(id) != null) {
            int currentQuantity = cosCumparaturi.get(id);
            int newQuantity = currentQuantity + 1;
            cosCumparaturi.put(id, newQuantity);
        } else {
            cosCumparaturi.put(id, 1);
        }
    }
}
