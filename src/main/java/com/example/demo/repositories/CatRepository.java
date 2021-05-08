package com.example.demo.repositories;

import com.example.demo.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
