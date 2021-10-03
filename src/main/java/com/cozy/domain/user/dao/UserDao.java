package com.cozy.domain.user.dao;

import com.cozy.domain.user.User;

public interface UserDao {

  void createUser(User user);

  String getEmail(String email);

  String getLoginId(String userId);
}
