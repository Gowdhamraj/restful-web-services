package com.gow.microservices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String name) {
        String formattedName = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        return userRepository.findById(formattedName).get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(String name) {
        String formattedName = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        User user = userRepository.findById(formattedName).get();
        userRepository.deleteById(formattedName);
        return user;
    }
}
