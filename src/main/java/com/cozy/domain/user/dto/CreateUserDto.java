package com.cozy.domain.user.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

  String loginId;
  String password;
  String email;
  String phoneNumber;
}
