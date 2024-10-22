package tech.chillo.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.chillo.products.entity.Product;
import tech.chillo.products.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List <User> findByNameContaining(String expression);
    @Query("FROM User where name like %?1")
    Iterable <User> getByExpression(String expression);
}
