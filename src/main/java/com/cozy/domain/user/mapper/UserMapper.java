package com.cozy.domain.user.mapper;

import com.cozy.domain.user.User;
import com.cozy.api.dto.CreateUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  void createUser(User user);

  String getEmail(String email);

  String getLoginId(String userId);

  User getUser(Long id);
}
