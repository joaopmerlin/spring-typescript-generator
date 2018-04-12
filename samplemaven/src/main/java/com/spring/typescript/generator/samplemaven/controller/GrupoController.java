package com.spring.typescript.generator.samplemaven.controller;

import com.spring.typescript.generator.annotation.*;
import com.spring.typescript.generator.samplemaven.data.GrupoData;
import com.spring.typescript.generator.samplemaven.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by joao on 17/08/17.
 */

@TsComponent(value = Grupo.class, crud = true)
@RestController
@RequestMapping("grupo")
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class GrupoController {

    @Autowired private GrupoData data;

    @GetMapping
    @TsCrudFindAll
    public List<Grupo> findAll() {
        return data.findAll();
    }

    @GetMapping("{id}")
    @TsCrudFindOne
    public Grupo findOne(@PathVariable("id") Long id) {
        return data.findOne(id);
    }

    @PostMapping
    @TsCrudSave
    public Grupo save(@RequestBody Grupo user) {
        return data.save(user);
    }

    @DeleteMapping("{id}")
    @TsCrudDelete
    public void delete(@PathVariable("id") Long id) {
        data.delete(id);
    }
}
