package com.dmandryianau.jwtexample.auth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserAPI{

  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/{userId}")
  public UserDto getUserById(@PathVariable Long userId) {
    var user = userService.findById(userId);
    return userMapper.toUserDto(user);
  }
}
