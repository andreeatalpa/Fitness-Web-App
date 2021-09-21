package ro.fitnessApp.FitnessApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fitnessApp.FitnessApp.dao.Client;
import ro.fitnessApp.FitnessApp.dao.ClientDAO;
import ro.fitnessApp.FitnessApp.exceptions.UserException;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDAO clientDAO;

    public void save(String email, String password, String name){
        Client client = new Client();
        client.setEmail(email);
        client.setParola(password);
        client.setNume(name);
        clientDAO.save(client);
    }

    public void checkPassword(String password, String pasword2) throws UserException {
        if (!password.equals(pasword2)){
            throw new UserException("parolele nu sunt identice din exception") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }
    public List<Client> getUserByEmail(String email){
        return clientDAO.findByEmail(email);
    }
}
