package ro.fitnessApp.FitnessApp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends CrudRepository<Client, Long> {
    List<Client> findByEmail(String email);

    Client save(Client client);

}
