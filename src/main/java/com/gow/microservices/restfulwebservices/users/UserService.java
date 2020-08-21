package com.gow.microservices.restfulwebservices.users;

import java.util.List;

public interface UserService
{
    public List<User> getAllUsers();
    public User getUser(String name);
    public User addUser(User user);
    public User deleteUser(String name);
}
