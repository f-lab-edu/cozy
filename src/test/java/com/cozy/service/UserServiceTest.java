package com.cozy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cozy.domain.user.User;
import com.cozy.api.dto.CreateUserDto;
import com.cozy.domain.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class UserServiceTest {

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  @Test
  void 회원정보_INSERT_테스트() {

    //given
    String plainPassword = "1234";

    CreateUserDto dto = CreateUserDto.builder()
        .phoneNumber("01012345678")
        .loginId("cozy")
        .email("cozy@gmail.com")
        .password(plainPassword)
        .build();

    //when
    Long id = userService.signUp(dto);
    User findUser = userMapper.getUser(id);

    //then
    assertEquals(dto.getPhoneNumber(), findUser.getPhoneNumber());
    assertTrue(BCrypt.checkpw(plainPassword, findUser.getPassword()));
    assertEquals(dto.getLoginId(), findUser.getLoginId());
    assertEquals(dto.getEmail(), findUser.getEmail());
  }

  @Test
  void 중복_아이디_가입여부_테스트() {
    //given
    CreateUserDto dto1 = CreateUserDto.builder()
        .phoneNumber("01012345678")
        .loginId("cozy")
        .email("cozy@gmail.com")
        .password("12341!")
        .build();

    CreateUserDto dto2 = CreateUserDto.builder()
        .phoneNumber("01052342122")
        .loginId("cozy")
        .email("biz@gmail.com")
        .password("1234214!!")
        .build();

    //when
    userService.signUp(dto1);

    //then
    Throwable exception = assertThrows(IllegalStateException.class, () -> {
      userService.signUp(dto2);
    });

    assertEquals(exception.getMessage(), "이미 존재하는 아이디 입니다");
  }

  @Test
  void 중복_이메일_가입여부_테스트() {
    //given
    CreateUserDto dto1 = CreateUserDto.builder()
        .phoneNumber("01012345678")
        .loginId("cozy")
        .email("cozy@gmail.com")
        .password("12341!")
        .build();

    CreateUserDto dto2 = CreateUserDto.builder()
        .phoneNumber("01052342122")
        .loginId("biz")
        .email("cozy@gmail.com")
        .password("1234214!!")
        .build();

    //when
    userService.signUp(dto1);

    //then
    Throwable exception = assertThrows(IllegalStateException.class, () -> {
      userService.signUp(dto2);
    });

    assertEquals(exception.getMessage(), "이미 존재하는 이메일 입니다");
  }
}