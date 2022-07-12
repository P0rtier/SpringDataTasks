package pl.uzi.springdatatasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.uzi.springdatatasks.dao.entities.Customer;
import pl.uzi.springdatatasks.dao.entities.Order;
import pl.uzi.springdatatasks.dao.entities.Product;
import pl.uzi.springdatatasks.dao.repositories.CustomerRepo;
import pl.uzi.springdatatasks.dao.repositories.OrderRepo;
import pl.uzi.springdatatasks.dao.repositories.ProductRepo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbMockData {
    private CustomerRepo customerRepository;
    private OrderRepo orderRepository;
    private ProductRepo productRepository;

    @Autowired
    public DbMockData(CustomerRepo customerRepository, OrderRepo orderRepository, ProductRepo productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){
        Product product = new Product("Korek", 2.55f, true);
        Product product1 = new Product("Rura", 5f, true);
        Customer customer = new Customer("Jak Kowalski", "Wrocław");
        Set<Product> products = new HashSet<>() {
            {
                add(product);
                add(product1);
            }};
        Order order = new Order(customer, products, LocalDateTime.now(), "in progress");

        productRepository.save(product);
        productRepository.save(product1);
        customerRepository.save(customer);
        orderRepository.save(order);
    }
}
