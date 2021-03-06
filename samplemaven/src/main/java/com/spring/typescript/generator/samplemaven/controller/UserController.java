package com.spring.typescript.generator.samplemaven.controller;

import com.spring.typescript.generator.annotation.*;
import com.spring.typescript.generator.samplemaven.data.UserData;
import com.spring.typescript.generator.samplemaven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by joao on 17/08/17.
 */

@TsComponent(value = User.class, crud = true)
@RestController
@RequestMapping("user")
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class UserController {

    @Autowired private UserData data;

    @GetMapping
    @TsCrudFindAll
    public List<User> findAll() {
        return data.findAll();
    }

    @GetMapping("{id}")
    @TsCrudFindOne
    public User findOne(@PathVariable("id") Long id) {
        return data.findOne(id);
    }

    @PostMapping
    @TsCrudSave
    public User save(@RequestBody User user) {
        return data.save(user);
    }

    @DeleteMapping("{id}")
    @TsCrudDelete
    public void delete(@PathVariable("id") Long id) {
        data.delete(id);
    }

}
