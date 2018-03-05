package com.spring.typescript.generator.samplemaven.controller;

import com.spring.typescript.generator.annotation.TsService;
import com.spring.typescript.generator.samplemaven.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joao on 17/08/17.
 */

@TsService("user.service")
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        return Arrays.asList(new User(1L, "user", "user@user.com"),
                new User(2L, "user2", "user2@user.com"),
                new User(3L, "user3", "user3@user.com"));
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, String.format("user%s", id), String.format("user%s@user.com", id));
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return user;
    }
}
