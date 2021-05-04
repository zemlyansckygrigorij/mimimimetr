package com.example.demo.entities;

import java.util.Objects;

public class Cat {
    private int id;
    private String name;
    private String path;
    private int rating;

    public Cat() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && rating == cat.rating && name.equals(cat.name) && path.equals(cat.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, path, rating);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
