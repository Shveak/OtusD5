package org.otus.service;

import lombok.SneakyThrows;
import org.otus.model.Rating;
import org.otus.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class UserService implements IUserService {
    @Override
    public List<User> getAllUser() {
        return LongStream
                .range(0, 3)
                .mapToObj(x -> new User("User-" + (x + 1), "QA", "user" + (x + 1) + "@mail.ru", (int) (30 + (x + 1) * 3)))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public Rating getRating(String name) {
        if (name.equalsIgnoreCase("mock")) {
            return new Rating("Заглушка", 555);
        } else {
            String[] arr = name.split("-");
            if (arr[0].equalsIgnoreCase("user") && arr.length > 1 && arr[1].matches("\\d")
                    && Integer.parseInt(arr[1]) <= 3 && Integer.parseInt(arr[1]) > 0) {
                return new Rating(name, 50 + Integer.parseInt(arr[1]));
            } else {
                throw new Exception("указанный пользователь отсутствует");
            }
        }
    }
}
