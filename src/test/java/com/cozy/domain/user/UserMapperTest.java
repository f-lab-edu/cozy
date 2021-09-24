package com.cozy.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import com.cozy.domain.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @ActiveProfiles?
 * 어떤 특정한 환경에 대해 설정 값을 다르게 하고싶을 때 사용할 수 있다.
 * 테스트 코드에서 많이 사용하는 어노테이션.
 * value 옵션으로 지정한 값에 해당하는 profile을 이용해 테스트를 수행시킬 수 있다.
 */

@ActiveProfiles("test")
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