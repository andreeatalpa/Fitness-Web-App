package ro.fitnessApp.FitnessApp.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComenziDAO extends CrudRepository<CosCumparaturi, Integer> {
}
