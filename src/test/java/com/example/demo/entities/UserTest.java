package com.example.demo.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class UserTest {
    @Test
    public void makeTest(){
        User user = new User();
        user.setUserId(1);
        user.setVoted(false);
        user.setEnabled(true);
        user.setPassword("sss");
        user.setName("User");
        user.setRole("ROLE_USER");

        assertEquals(1,user.getUserId());
        assertEquals("User",user.getName());
        assertEquals("sss",user.getPassword());
        assertEquals("ROLE_USER",user.getRole());
        assertTrue(user.isEnabled());
        assertFalse(user.isVoted());

    }
}