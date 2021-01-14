package com.example.springbootrediscache.controllers;

import com.example.springbootrediscache.models.Visitas;
import com.example.springbootrediscache.repository.VisitasRepository;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/visitas")
public class VisitasController{

    @Autowired
    private VisitasRepository visitasRepository;

    public VisitasController(VisitasRepository visitasRepository){
        this.visitasRepository = visitasRepository;
    }

    @GetMapping("/all")
    public Map<Long, Visitas> GetAll(){
        return visitasRepository.findAll();
    }
    @PostMapping("/add")
    public Visitas add(@RequestBody Visitas visitas){
        visitasRepository.save(visitas);
        return visitasRepository.findById(visitas.getId());
    }
    @PostMapping("/update")
    public Visitas update(@RequestBody Visitas visitas){
        visitasRepository.update(visitas);
        return visitasRepository.findById(visitas.getId());
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        visitasRepository.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Visitas getById(@PathVariable Long id){
        return visitasRepository.findById(id);
    }
}
