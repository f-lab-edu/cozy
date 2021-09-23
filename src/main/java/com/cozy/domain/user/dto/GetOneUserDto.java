package com.cozy.domain.user.dto;

import lombok.Value;
import org.apache.ibatis.type.Alias;

@Value
@Alias("GetOneUserDto")
public class GetOneUserDto {

  String loginId;
  String password;
  String email;
  String phoneNumber;
}
