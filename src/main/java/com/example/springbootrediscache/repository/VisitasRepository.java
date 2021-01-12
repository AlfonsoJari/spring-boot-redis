package com.example.springbootrediscache.repository;

import com.example.springbootrediscache.models.Visitas;
import java.util.Map;

public interface VisitasRepository {
    void save(Visitas visitas);
    Map<Long, Visitas> findAll();
    Visitas findById(Long id);
    void update(Visitas visitas);
    void delete(Long id);
}