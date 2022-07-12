package pl.uzi.springdatatasks.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.uzi.springdatatasks.entities.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {
}
