package com.example.demo.repositories;

import com.example.demo.entities.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
