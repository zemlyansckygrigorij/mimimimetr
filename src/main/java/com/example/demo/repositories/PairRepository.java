package com.example.demo.repositories;

import com.example.demo.entities.Pair;
import org.springframework.data.repository.CrudRepository;

public interface PairRepository  extends CrudRepository<Pair, Long> {
}
