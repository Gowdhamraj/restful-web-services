package com.gow.microservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserDaoService {
    private static Map<String, User> userDb = new LinkedHashMap<>();
    static
    {
        userDb.put("Gow", new User("Gow", 1, new Date()));
        userDb.put("Rags", new User("Rags", 2, new Date()));
        userDb.put("Parks", new User("Parks", 3, new Date()));
    }
    //getAllUsers
    public List<User> getAllUsers()
    {
        Collection<User> users = userDb.values();
        return users.stream().collect(Collectors.toList());
    }
    //getUser
    public User getUser(String name)
    {
        String formattedName = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        return userDb.get(formattedName);
    }
    //addUser
    public User addUser(User user)
    {
        if (user.getName() != null)
        {
            userDb.put(user.getName(), user);
            return userDb.get(user.getName());
        }
        return null;
    }
    //deleteUser
    public User deleteUser(String name)
    {
        String formattedName = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        return userDb.remove(formattedName);
    }
}
