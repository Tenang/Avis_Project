package tech.chillo.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.chillo.products.entity.Product;
import tech.chillo.products.service.ProductService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private ProductService productService;
    @GetMapping
    public Iterable<Product> search(@RequestParam (required = false) String name,
                                    @RequestParam (required = false) String sentiment){
        return this.productService.search(name, sentiment);
    }


}
