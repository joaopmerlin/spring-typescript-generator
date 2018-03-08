package com.spring.typescript.generator.samplemaven.controller;

import com.spring.typescript.generator.annotation.TsService;
import com.spring.typescript.generator.samplemaven.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id, @RequestParam("teste") Integer teste) {
        return new User();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<User> saveUser(@RequestBody List<User> users, int teste) {
        return users;
    }
}
