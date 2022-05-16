package com.patel.productapi;

import com.patel.productapi.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;


@SpringBootTest
class ProductApiApplicationTests {

    @Test
    void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product= restTemplate.getForObject("http://localhost:8901/ShopApi/products/", Product.class);
        assertNotNull(product);
        assertEquals("Sugar",product.getName());

    }

}
