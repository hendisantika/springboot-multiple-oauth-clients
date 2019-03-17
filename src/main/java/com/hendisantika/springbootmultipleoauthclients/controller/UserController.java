package com.hendisantika.springbootmultipleoauthclients.controller;

import com.hendisantika.springbootmultipleoauthclients.domain.User;
import com.hendisantika.springbootmultipleoauthclients.security.ApplicationUserDetails;
import com.hendisantika.springbootmultipleoauthclients.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multiple-oauth-clients
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-17
 * Time: 20:43
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/me")
    public User getMe(@AuthenticationPrincipal ApplicationUserDetails userDetails) {
        return userService.getById(userDetails.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}