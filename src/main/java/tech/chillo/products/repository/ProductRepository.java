package tech.chillo.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.products.entity.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    //select* from product where name= param

    Iterable <Product> findByName(String name);
    //select* from product where name= param

    Iterable <Product> findByNameContainsOrderByPriceDesc(String name);

    Iterable <Product> findByPriceAfter(int price);

    List<Product> findBySentimentsTextContaining(String text);

}
