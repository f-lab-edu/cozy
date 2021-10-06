package com.cozy.api.dto;

import static com.cozy.constant.UserConstant.LOG_ROUND;

import com.cozy.domain.user.User;
import lombok.Builder;
import lombok.Value;
import org.mindrot.jbcrypt.BCrypt;

@Value
@Builder
public class CreateUserDto {

  String loginId;
  String password;
  String email;
  String phoneNumber;

  public User toEntity() {
    String encodePassword = BCrypt
        .hashpw(this.password, BCrypt.gensalt(LOG_ROUND));

    return User.builder()
        .loginId(this.loginId)
        .password(encodePassword)
        .email(this.email)
        .phoneNumber(this.phoneNumber)
        .build();
  }
}
