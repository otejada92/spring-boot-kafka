package com.javatest.producer.user;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String name;
    private String email;

    public User(String name, String email) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("{'username' : '%s', 'email' : '%s'}", name, email);
    }
}
