package org.otus.service;

import org.otus.model.Rating;
import org.otus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class UserService implements IUserService {
    @Override
    public List<User> getAllUser() {
        return LongStream
                .range(0, 20)
                .mapToObj(x -> new User("UserName " + x, "QA", "user" + x + "@mail.ru", 20 + new Random().nextInt(20)))
                .collect(Collectors.toList());
    }

    @Override
    public Rating getRating(String name) {
        return new Rating(name, 20 + new Random().nextInt(50));
    }
}
