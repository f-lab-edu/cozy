package com.cozy.domain.user.dao;

import com.cozy.domain.user.User;
import com.cozy.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoJdbc implements UserDao {

  private final UserMapper userMapper;

  @Override
  public void createUser(User user) {
    userMapper.createUser(user);
  }

  @Override
  public String getEmail(String email) {
    return userMapper.getEmail(email);
  }

  @Override
  public String getLoginId(String loginId) {
    return userMapper.getLoginId(loginId);
  }
}
