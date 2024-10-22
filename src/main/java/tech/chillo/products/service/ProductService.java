package tech.chillo.products.service;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import tech.chillo.products.entity.Product;
import tech.chillo.products.entity.Sentiment;
import tech.chillo.products.entity.User;
import tech.chillo.products.repository.ProductRepository;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor

@Service
public class ProductService {
    private ProductRepository productRepository;

    public Iterable<Product> search(String name, String sentiment){

        if (Strings.isNotEmpty(name)){
            return  this.productRepository.findByNameContainsOrderByPriceDesc(name);
        } if (Strings.isNotEmpty(sentiment)){
            return  this.productRepository.findBySentimentsTextContaining(sentiment);
        }
        return this.productRepository.findAll();

    }


    public void InitializeProducts(){
        Faker faker = new Faker();
        final List<Product> products = IntStream.range(30,100).mapToObj(index -> {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .build();
          final List<Sentiment> sentiments =  IntStream.range(2,5).mapToObj(
                    i-> Sentiment
                            .builder()
                            .user(user)
                            .creation(Instant.now())
                            .text(faker.lorem().sentence())
                            .build())
                    .collect(Collectors.toList());
             return Product.builder()
                     .sentiments(sentiments)
                    .name("Product" + index)
                    .price(index*100)
                    .build();
                }
                
        ).collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }
}
