package com.dmandryianau.jwtexample.auth.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

  UserDetailsService userDetailsService();

  User findById(Long userId);
}
