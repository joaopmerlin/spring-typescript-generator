package com.spring.typescript.generator.samplemaven.controller;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsCrudDelete;
import com.spring.typescript.generator.annotation.TsCrudFind;
import com.spring.typescript.generator.annotation.TsCrudSave;
import com.spring.typescript.generator.samplemaven.data.UserData;
import com.spring.typescript.generator.samplemaven.model.Empresa;
import com.spring.typescript.generator.samplemaven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @TsCrudFind
    public List<User> getUsers() {
        return data.findAll();
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

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id, @RequestParam("teste") Integer teste) {
        return new User();
    }

    @GetMapping("empresa")
    public Empresa getEmpresa(@RequestParam("id") Long id) {
        return new Empresa();
    }
}
