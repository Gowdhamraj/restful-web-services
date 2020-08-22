package com.gow.microservices.restfulwebservices.users;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    public List<User> getAllUsers();
    public Optional<User> getUser(String name);
    public User addUser(User user);
    public Optional<User> deleteUser(String name);
}
