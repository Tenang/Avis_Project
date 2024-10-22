package tech.chillo.products.service;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import tech.chillo.products.entity.Product;
import tech.chillo.products.entity.Sentiment;
import tech.chillo.products.entity.User;
import tech.chillo.products.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    public Iterable<User> search(String name){

        if (Strings.isNotEmpty(name)){
            return  this.userRepository.getByExpression(name);
        }
        return this.userRepository.findByNameContaining(name);

    }


}
