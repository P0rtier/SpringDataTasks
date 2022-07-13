package pl.uzi.springdatatasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.uzi.springdatatasks.dao.entities.Order;
import pl.uzi.springdatatasks.managers.OrderManager;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class OrderApi {

    private OrderManager orderManager;
    @Autowired
    public OrderApi(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping("orders/all")
    public Iterable<Order> getAll(){
        return orderManager.findAll();
    }

    @GetMapping("/orders")
    public Order getByIndex(@RequestParam Long index){
        return orderManager.findById(index);
    }

    @PostMapping("/admin/orders")
    public Order postOrder(@RequestBody Order order){
        return orderManager.save(order);
    }

    @PutMapping("/admin/orders")
    public Order putOrder(@RequestParam Long index, @RequestBody Order order){
        Order order1 = new Order();
        order1.setId(index);
        order1.setStatus(order.getStatus());
        order1.setCustomer(order.getCustomer());
        order1.setProducts(order.getProducts());
        order1.setPlaceDate(order.getPlaceDate());
        return orderManager.save(order1);
    }

    @PatchMapping("/admin/orders")
    public boolean patchOrder(@RequestParam Long index, @RequestBody Order order){
        try {
            Order order1 = orderManager.findById(index);
            boolean needUpdate = false;

            if(StringUtils.hasLength(String.valueOf(order.getCustomer()))){
                order1.setCustomer(order.getCustomer());
                needUpdate = true;
            }

            if(StringUtils.hasLength(String.valueOf(order.getProducts()))){
                order1.setProducts(order.getProducts());
                needUpdate = true;
            }

            if(StringUtils.hasLength(String.valueOf(order.getPlaceDate()))){
                order1.setPlaceDate(order.getPlaceDate());
                needUpdate = true;
            }

            if(StringUtils.hasLength(order.getStatus())){
                order1.setStatus(order.getStatus());
                needUpdate = true;
            }

            if(needUpdate){
                orderManager.save(order1);
                return true;
            }
        }catch (NoSuchElementException e){
            System.err.println("No such element!");
        }
        return false;
    }

    @DeleteMapping("/admin/orders")
    public void deleteOrder(@RequestParam Long index){
        orderManager.delete(index);
    }
}
