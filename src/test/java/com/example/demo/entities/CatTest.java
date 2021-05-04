package com.example.demo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    @Test
    public void makeTest(){
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("barsic");
        cat.setPath("111");
        cat.setRating(12);
        assertEquals(1,cat.getId());
        assertEquals("barsic",cat.getName());
        assertEquals("111",cat.getPath());
        assertEquals(12,cat.getRating());

        Cat cat1 = new Cat();
        cat1.setId(1);
        cat1.setName("barsic");
        cat1.setPath("111");
        cat1.setRating(12);
        assertEquals(cat1 ,cat);

        Cat cat2 = new Cat();
        cat2.setId(2);
        cat2.setName("barsic2");
        cat2.setPath("1112");
        cat2.setRating(11);
        assertNotEquals(cat1 ,cat2);
    }
}