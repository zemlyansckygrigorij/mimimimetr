package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cat {
    @Id
    private long cId;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "rating")
    private int rating;

    public Cat() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return cId == cat.cId && rating == cat.rating && name.equals(cat.name) && path.equals(cat.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, name, path, rating);
    }

    public long getId() {
        return cId;
    }

    public void setId(long id) {
        this.cId = id;
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
