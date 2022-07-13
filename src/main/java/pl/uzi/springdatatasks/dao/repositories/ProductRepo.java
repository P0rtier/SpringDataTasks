package pl.uzi.springdatatasks.dao.repositories;

import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.uzi.springdatatasks.dao.entities.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
}
