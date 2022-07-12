package pl.uzi.springdatatasks.repositories;

import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;
import pl.uzi.springdatatasks.entities.Product;

@Registered
public interface ProductRepo extends CrudRepository<Product,Long> {
}
