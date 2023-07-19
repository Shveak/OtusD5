package org.otus.controller;

import org.otus.model.Rating;
import org.otus.model.User;
import org.otus.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return iUserService.getAllUser();
    }

    @GetMapping("/{id}")
    public Rating getRatingByName(@PathVariable String id) {
        return iUserService.getRating(id);
    }
}
