package pl.uzi.springdatatasks.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.uzi.springdatatasks.dao.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
