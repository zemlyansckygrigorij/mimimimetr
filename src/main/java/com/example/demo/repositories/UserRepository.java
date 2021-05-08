package com.example.demo.repositories;


import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name = :name")
    public User getUserByUsername(@Param("name") String name);
}
