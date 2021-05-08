package com.example.demo.repositories;

import com.example.demo.entities.Cat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class CatRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CatRepository repository;
    @Test
    public void test() {
        long countFirst = repository.count();
        assertEquals(0, countFirst);
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("barsic");
        cat.setPath("111");
        cat.setRating(12);

        entityManager.persist(cat);

        long count = repository.count();
        assertEquals(1, count);

    }

}