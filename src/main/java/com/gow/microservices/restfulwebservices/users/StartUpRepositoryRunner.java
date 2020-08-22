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

    private static final Post MLADY = new Post(1111, "M'LADY", JON_SNOW);
    private static final Post DRACARYS = new Post(2111, "Dracarys", DAENERYS_TARGARYEN);
    private static final Post KNOW_NOTHING = new Post(1123, "I don't know", JON_SNOW);

    @Autowired
    UserRepository myUserRepository;

    @Autowired
    PostRepository myPostRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> iceAndFire = ImmutableList.of(JON_SNOW, DAENERYS_TARGARYEN, SANSA_STARK);
        myUserRepository.saveAll(iceAndFire);

        List<Post> valerian = ImmutableList.of(MLADY, DRACARYS, KNOW_NOTHING);
        myPostRepository.saveAll(valerian);
    }
}
