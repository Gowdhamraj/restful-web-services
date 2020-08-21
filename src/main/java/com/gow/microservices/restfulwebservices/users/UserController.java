package com.gow.microservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    private UserDaoService myUserDaoService;

    @Autowired
    public UserController(UserDaoService userDaoService)
    {
        myUserDaoService = userDaoService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers()
    {
        return myUserDaoService.getAllUsers();
    }

    @GetMapping(path = "/{name}")
    public User getUser(@PathVariable String name)
    {
        User user = myUserDaoService.getUser(name);
        if (user == null)
        {
            throw new UserNotFoundException("User not found with the name " + name);
        }
        return user;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@Valid @RequestBody User user)
    {
        User savedUser = myUserDaoService.addUser(user);
        if (savedUser != null)
        {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{name}")
                    .buildAndExpand(savedUser.getName())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.status(406).build();
    }

    @DeleteMapping(path = "/{name}")
    public User deleteUser(@PathVariable String name)
    {
        User user = myUserDaoService.deleteUser(name);
        if (user == null)
        {
            throw new UserNotFoundException("User not found with the name " + name);
        }
        return user;
    }
}
