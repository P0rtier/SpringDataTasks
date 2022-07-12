package pl.uzi.springdatatasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.uzi.springdatatasks.entities.Product;
import pl.uzi.springdatatasks.repositories.ProductRepo;

@Component
public class Start {
    ProductRepo repo;

    @Autowired
    public Start(ProductRepo repo){
        this.repo = repo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
//        repo.save(new Product("Bread", 2.4f,true));
//        repo.save(new Product("Bread2", 2.5f,true));
//        repo.save(new Product("Bread3", 2.6f,false));
//        repo.save(new Product("Bread4", 2.7f,false));
    }
}
