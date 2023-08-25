package org.example.testaverde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path={"/users"}, produces = APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path= "/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping(path="/search")
    public List<User> searchUsers(@RequestParam String param) {
        return userRepository.search(param);
    }

}
