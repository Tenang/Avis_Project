package tech.chillo.products;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.chillo.products.service.ProductService;

@SpringBootApplication
@AllArgsConstructor
public class ProductsApplication implements CommandLineRunner {

    private ProductService productService;
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.productService.InitializeProducts();
    }
}
