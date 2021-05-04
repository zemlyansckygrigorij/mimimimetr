package com.example.demo.entities;

import java.util.Objects;

public class Pair {
    private Cat firstCat;
    private Cat secondCat;

    public Pair() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return firstCat.equals(pair.firstCat) && secondCat.equals(pair.secondCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCat, secondCat);
    }

    public Cat getFirstCat() {
        return firstCat;
    }

    public void setFirstCat(Cat firstCat) throws Exception {
        if(firstCat.equals(secondCat)) throw new Exception();
        this.firstCat = firstCat;
    }

    public Cat getSecondCat() {
        return secondCat;
    }

    public void setSecondCat(Cat secondCat) throws Exception {
        if(secondCat.equals(firstCat)) throw new CatException();
        this.secondCat = secondCat;
    }
}
