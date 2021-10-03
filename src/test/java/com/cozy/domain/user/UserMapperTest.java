package com.cozy.domain.user;

import static com.cozy.constant.UserConstant.LOG_ROUND;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cozy.api.dto.CreateUserDto;
import com.cozy.domain.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @ActiveProfiles? 어떤 특정한 환경에 대해 설정 값을 다르게 하고싶을 때 사용할 수 있다. 테스트 코드에서 많이 사용하는 어노테이션. value 옵션으로 지정한
 * 값에 해당하는 profile을 이용해 테스트를 수행시킬 수 있다.
 * @SpringBootTest?
 * @SpringBootTest는 테스트에 사용할 ApplicationContext를 생성하고 빈들을 불러오는 역할을 수행한다.
 * @SpringBootTest를 별다른 옵션을 지정하지 않고 이용하면 해당 애플리케이션 상에 정의된 모든 빈을 ApplicationContext로 불러온다. 또한,
 * classes 옵션을 이용해 빈을 생성할 @Configuration 클래스를 직접 지정할 수도 있다.
 */

@ActiveProfiles("test")
@SpringBootTest
class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void 유저_생성() {

    //given
    String encodePassword = BCrypt
        .hashpw("1234", BCrypt.gensalt(LOG_ROUND));

    User user = User.builder()
        .loginId("cozy")
        .password(encodePassword)
        .phoneNumber("01012344321")
        .email("cozy@gmail.com")
        .build();

    //when
    Long id = userMapper.createUser(user);

    //then
    User findUser = userMapper.getUser(id);
    assertEquals(user.getEmail(), findUser.getEmail());
    assertEquals(user.getPassword(), findUser.getPassword());
    assertEquals(user.getLoginId(), findUser.getLoginId());
    assertEquals(user.getPhoneNumber(), findUser.getPhoneNumber());
  }

}