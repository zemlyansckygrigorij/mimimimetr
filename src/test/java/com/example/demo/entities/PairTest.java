package com.example.demo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    @Test
    public void makeTest()  {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("barsic");
        cat.setPath("111");
        cat.setRating(12);

        Cat cat1 = new Cat();
        cat1.setId(1);
        cat1.setName("barsic");
        cat1.setPath("111");
        cat1.setRating(12);

        Cat cat2 = new Cat();
        cat2.setId(2);
        cat2.setName("barsic2");
        cat2.setPath("1112");
        cat2.setRating(11);
        assertNotEquals(cat1 ,cat2);


        Pair pair = new Pair();

        assertEquals(cat1 ,cat);
        assertThrows(CatException.class, () -> {
            pair.setFirstCat(cat);
            pair.setSecondCat(cat1);
        });
       assertDoesNotThrow( () -> {
           pair.setFirstCat(cat);
           pair.setSecondCat(cat2);
       });

        assertEquals(cat ,pair.getFirstCat());
        assertEquals(cat2 ,pair.getSecondCat());
    }
}