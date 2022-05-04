package com.patel.productapi.productApi;


import com.patel.productapi.models.Product;
import com.patel.productapi.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
   private ProductRepository repository;

    @RequestMapping(value="/products/",method = RequestMethod.GET)
    public List<Product> getProducts() {

        return repository.findAll();


    }
    @RequestMapping(value="/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){

        return repository.findById(id).get();
    }
    @RequestMapping(value="/products/",method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){

        return repository.save(product);
    }

    @RequestMapping(value="/products/",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){

        return repository.save(product);
    }
    @RequestMapping(value="/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id){

        repository.deleteById(id);
    }













}