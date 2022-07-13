package pl.uzi.springdatatasks.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uzi.springdatatasks.dao.entities.Customer;
import pl.uzi.springdatatasks.dao.repositories.CustomerRepo;

import java.util.Optional;

@Service
public class CustomerManager {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Iterable<Customer> findAll(){
        return customerRepo.findAll();
    }

    public Optional<Customer> findByIndex(Long index){
        return customerRepo.findById(index);
    }

    public Customer save(Customer customer){
        return customerRepo.save(customer);
    }

    public void delete(Long index){
        customerRepo.deleteById(index);
    }
}
