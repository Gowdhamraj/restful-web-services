package com.gow.microservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    private UserService myUserService;

    @Autowired
    public UserController(UserService userService)
    {
        myUserService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers()
    {
        return myUserService.getAllUsers();
    }

    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByName(@PathVariable String name)
    {
        return getUser(name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@Valid @RequestBody User user)
    {
        User savedUser = myUserService.addUser(user);
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

    @DeleteMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUser(@PathVariable String name)
    {
        Optional<User> user = myUserService.deleteUser(name);
        if (!user.isPresent())
        {
            throw new UserNotFoundException("User not found with the name " + name);
        }
        return user.get();
    }

    @GetMapping(path = "/{name}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getPostsByUserName(@PathVariable String name)
    {
        return getUser(name).getPosts();
    }

    private User getUser(String name) throws UserNotFoundException
    {
        Optional<User> user = myUserService.getUser(name);
        if (!user.isPresent())
        {
            throw new UserNotFoundException("User not found with the name " + name);
        }
        return user.get();
    }
}
