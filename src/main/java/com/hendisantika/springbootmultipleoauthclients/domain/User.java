package com.hendisantika.springbootmultipleoauthclients.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multiple-oauth-clients
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-17
 * Time: 20:38
 */
public class User {
    private long id;
    private String email;
    private String password;
    private Set<UserRole> roles;

    public User(long id, String email, String password, Set<UserRole> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
