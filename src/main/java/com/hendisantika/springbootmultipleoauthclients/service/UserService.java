package com.hendisantika.springbootmultipleoauthclients.service;

import com.hendisantika.springbootmultipleoauthclients.domain.User;

import java.util.Optional;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multiple-oauth-clients
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-17
 * Time: 20:39
 */
public interface UserService {
    Set<User> getUsers();

    Optional<User> getByEmail(String email);

    Optional<User> getById(long userId);
}
