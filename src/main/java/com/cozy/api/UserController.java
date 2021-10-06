package com.cozy.api;

import com.cozy.api.dto.CreateUserDto;
import com.cozy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public void createUser(@RequestBody CreateUserDto createUserDto) {
    userService.signUp(createUserDto);
  }
}
