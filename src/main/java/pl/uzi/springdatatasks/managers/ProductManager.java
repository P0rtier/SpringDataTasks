package pl.uzi.springdatatasks.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uzi.springdatatasks.dao.entities.Product;
import pl.uzi.springdatatasks.dao.repositories.ProductRepo;

import java.util.Optional;

@Service
public class ProductManager {

    private ProductRepo productRepo;

    @Autowired
    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Optional<Product> find(Long index){
        return productRepo.findById(index);
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public Product save(Product product){
        return productRepo.save(product);
    }

    public void delete(Long index){
        productRepo.deleteById(index);
    }
}
