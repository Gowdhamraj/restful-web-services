package com.gow.microservices.restfulwebservices.users;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class StartUpRepositoryRunner implements CommandLineRunner {

    private static final User JON_SNOW = new User("Jon", 145, new Date());
    private static final User SANSA_STARK = new User("Sansa", 456, new Date());
    private static final User DAENERYS_TARGARYEN = new User("Daenerys", 987, new Date());

    @Autowired
    UserRepository myUserRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> iceAndFire = ImmutableList.of(JON_SNOW, DAENERYS_TARGARYEN, SANSA_STARK);
        myUserRepository.saveAll(iceAndFire);
    }
}
