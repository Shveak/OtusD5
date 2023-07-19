package org.otus.service;

import org.otus.model.Rating;
import org.otus.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();

    Rating getRating(String name);
}
