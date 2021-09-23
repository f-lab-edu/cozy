package com.cozy.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import com.cozy.domain.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void 유저_생성() {

    //given
    CreateUserDto user = CreateUserDto.builder()
        .loginId("cozy")
        .password("1234!@")
        .phoneNumber("01012344321")
        .email("cozy@gmail.com")
        .build();

    //when
    Long id = userMapper.createUser(user);

    //then
    GetOneUserDto findUser = userMapper.getOneUser(id);
    assertEquals(user.getEmail(), findUser.getEmail());
    assertEquals(user.getPassword(), findUser.getPassword());
    assertEquals(user.getLoginId(), findUser.getLoginId());
    assertEquals(user.getPhoneNumber(), findUser.getPhoneNumber());
  }

}