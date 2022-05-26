package com.patel.productapi;

import com.patel.productapi.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;


@SpringBootTest
class ProductApiApplicationTests {


    @Value("${productrestapi.services.url}")
    private String baseUrl;

    @Test
    public void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product= restTemplate.getForObject(baseUrl+ "1", Product.class);
        assertNotNull(product);
        assertEquals("Sugar " ,product.getName());

    }
    @Test
    public void testCreateProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product=new Product();
        product.setId(2);
        product.setName("Samsung Mobile");
        product.setDescription("It is awesome");
        product.setPrice(1000);
       Product newproduct= restTemplate.postForObject(baseUrl ,product,Product.class);
       assertNotNull(newproduct);
       assertNotNull(newproduct.getId());
       assertEquals("Samsung Mobile",newproduct.getName());


    }

}
