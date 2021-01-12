package com.example.springbootrediscache.repository;

import com.example.springbootrediscache.models.Visitas;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class VisitasRepositoryImpl implements VisitasRepository {

    private RedisTemplate<Long, Visitas> redisTemplate;

    private HashOperations hashOperations;

    public VisitasRepositoryImpl(RedisTemplate<Long, Visitas> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(Visitas visitas) {
        hashOperations.put("VISITAS",visitas.getId(),visitas);
    }
    @Override
    public Map<Long, Visitas> findAll() {
        return hashOperations.entries("VISITAS");
    }
    @Override
    public Visitas findById(Long id) {
        return (Visitas)hashOperations.get("VISITAS",id);
    }
    @Override
    public void update(Visitas visitas){
        save(visitas);
    }
    @Override
    public void delete(Long id){
        hashOperations.delete("VISITAS", id);
    }

}