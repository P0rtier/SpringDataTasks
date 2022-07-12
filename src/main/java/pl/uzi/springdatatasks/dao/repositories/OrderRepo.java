package pl.uzi.springdatatasks.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.uzi.springdatatasks.dao.entities.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order,Long> {
}
