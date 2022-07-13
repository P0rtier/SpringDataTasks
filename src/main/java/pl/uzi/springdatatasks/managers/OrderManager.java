package pl.uzi.springdatatasks.managers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uzi.springdatatasks.dao.entities.Order;
import pl.uzi.springdatatasks.dao.repositories.OrderRepo;

import java.util.NoSuchElementException;

@Service
public class OrderManager {

    private OrderRepo orderRepo;

    @Autowired
    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order save(Order order){
        return orderRepo.save(order);
    }

    public Iterable<Order> findAll(){
        return orderRepo.findAll();
    }

    public Order findById(Long index){
        return orderRepo.findById(index).orElseThrow(NoSuchElementException::new);
    }

    public void delete(Long index){
        orderRepo.deleteById(index);
    }
}
