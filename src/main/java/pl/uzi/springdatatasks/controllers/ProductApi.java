package pl.uzi.springdatatasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.uzi.springdatatasks.dao.entities.Product;
import pl.uzi.springdatatasks.managers.ProductManager;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ProductApi {

    private ProductManager productManager;

    @Autowired
    public ProductApi(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductApi() {
    }

    @GetMapping("/product/all")
    public Iterable<Product> getAll(){
        return productManager.findAll();
    }

    @GetMapping("/product")
    public Product getById(@RequestParam Long index){
        return productManager.find(index).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/admin/product")
    public Product postElem(@RequestBody Product product){
        return productManager.save(product);
    }

    @DeleteMapping("/product")
    public void delete(@RequestParam Long index){
        productManager.delete(index);
    }

    @PutMapping("/admin/product")
    public Product putElement(@RequestParam Long index, @RequestBody Product product){
        Product product1 = new Product();
        product1.setId(index);
        product1.setAvailable(product.isAvailable());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productManager.save(product1);
    }

    @PatchMapping("/admin/product")
    public boolean postElement(@RequestParam Long index, @RequestBody Product product){

        try{
            Product product1 = productManager.find(index).orElseThrow(NoSuchElementException::new);
            boolean needUpdate = false;

            if(StringUtils.hasLength(product.getName())){
                product1.setName(product.getName());
                needUpdate = true;
            }

            if(StringUtils.hasLength(String.valueOf(product.getPrice()))){
                product1.setPrice(product.getPrice());
                needUpdate = true;
            }

            if(StringUtils.hasLength(String.valueOf(product.isAvailable()))){
                product1.setAvailable(product.isAvailable());
                needUpdate = true;
            }

            if(needUpdate){
                productManager.save(product1);
                return true;
            }
        }catch (NoSuchElementException e){
            System.err.println("No such element exception!");
        }

        return false;

    }


}
