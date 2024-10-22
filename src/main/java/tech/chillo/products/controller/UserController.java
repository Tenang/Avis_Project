package tech.chillo.products.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.chillo.products.entity.Product;
import tech.chillo.products.entity.User;
import tech.chillo.products.service.UserService;


@AllArgsConstructor
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private UserService userService;

    @GetMapping
    public Iterable<User> search(@RequestParam (required = false) String name){
        return this.userService.search(name);
    }
}
