package com.hendisantika.springbootmultipleoauthclients.service;

import com.hendisantika.springbootmultipleoauthclients.domain.User;
import com.hendisantika.springbootmultipleoauthclients.domain.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multiple-oauth-clients
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-17
 * Time: 20:40
 */
@Service
public class UserServiceImpl implements UserService {

    private final Set<User> users = new HashSet<>();

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        users.add(new User(1, "player@example.com",
                passwordEncoder.encode("pwd-player"),
                new HashSet<>(Arrays.asList(UserRole.USER, UserRole.PLAYER))));
        users.add(new User(2, "admin@example.com",
                passwordEncoder.encode("pwd-admin"),
                new HashSet<>(Arrays.asList(UserRole.USER, UserRole.ADMINISTRATOR))));
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<User> getById(long userId) {
        return users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst();
    }
}