package com.hendisantika.springbootmultipleoauthclients.security;

import com.hendisantika.springbootmultipleoauthclients.domain.User;
import com.hendisantika.springbootmultipleoauthclients.domain.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multiple-oauth-clients
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-17
 * Time: 20:41
 */
public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {
    private static final String ROLE_PREFIX = "ROLE_";

    private final long userId;

    public ApplicationUserDetails(User user) {
        super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
        this.userId = user.getId();
    }

    private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole> roles) {
        return roles.stream()
                .map(userRole -> new SimpleGrantedAuthority(ROLE_PREFIX + userRole.name()))
                .collect(Collectors.toSet());
    }

    public long getUserId() {
        return userId;
    }
}