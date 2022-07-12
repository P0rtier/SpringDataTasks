package pl.uzi.springdatatasks.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.uzi.springdatatasks.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
