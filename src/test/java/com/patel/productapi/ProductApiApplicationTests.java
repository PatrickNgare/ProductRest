package com.patel.productapi;

import com.patel.productapi.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;


@SpringBootTest
class ProductApiApplicationTests {

    @Test
    public void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product= restTemplate.getForObject("http://localhost:8901/ShopApi/products/1", Product.class);
        assertNotNull(product);
        assertEquals("Sugar " ,product.getName());

    }
    @Test
    public void testCreateProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product=new Product();
        product.setName("Samsung Mobile");
        product.setDescription("It is awesome");
        product.setPrice(1000);
       Product newproduct= restTemplate.postForObject("http://localhost:8901/ShopApi/products/",product,Product.class);
       assertNotNull(newproduct);
       assertNotNull(newproduct.getId());
       assertEquals("Samsung Mobile",newproduct.getName());


    }

}
