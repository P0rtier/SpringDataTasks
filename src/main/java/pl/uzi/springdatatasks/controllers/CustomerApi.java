package pl.uzi.springdatatasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.uzi.springdatatasks.dao.entities.Customer;
import pl.uzi.springdatatasks.managers.CustomerManager;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class CustomerApi {

    private CustomerManager customerManager;

    @Autowired
    public CustomerApi(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @GetMapping("/customer/all")
    public Iterable<Customer> getAll(){
        return customerManager.findAll();
    }

    @GetMapping("/customer")
    public Customer getByID(@RequestParam Long index){
        return customerManager.findByIndex(index).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/admin/customer")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerManager.save(customer);
    }

    @PutMapping("/admin/customer")
    public Customer putCustomer(@RequestParam Long index, @RequestBody Customer customer){
        Customer customer1 = new Customer();
        customer1.setId(index);
        customer1.setName(customer.getName());
        customer1.setAddress(customer.getAddress());
        return customerManager.save(customer1);
    }

    @PatchMapping("/admin/customer")
    public boolean patchCustomer(@RequestParam Long index, @RequestBody Customer customer){
        try {
            Customer customer1 = customerManager.findByIndex(index).orElseThrow(NoSuchElementException::new);
            boolean needUpdate = false;

            if(StringUtils.hasLength(customer.getName())){
                customer1.setName(customer.getName());
                needUpdate = true;
            }

            if(StringUtils.hasLength(customer.getAddress())){
                customer1.setAddress(customer.getAddress());
                needUpdate = true;
            }

            if(needUpdate){
                customerManager.save(customer1);
                return true;
            }
        }catch (NoSuchElementException e){
            System.err.println("No such element!");
        }
        return false;
    }

    @DeleteMapping("/customer")
    public void deleteByIndex(@RequestParam Long index){
        try {
            customerManager.delete(index);
        }catch (NoSuchElementException e){
            System.err.println("No such element");
        }
    }

}
