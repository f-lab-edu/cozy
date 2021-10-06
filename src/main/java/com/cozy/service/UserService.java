package com.cozy.service;

import com.cozy.domain.user.User;
import com.cozy.domain.user.dao.UserDao;
import com.cozy.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cozy.api.dto.CreateUserDto;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDao userDao;

  @Transactional
  public Long signUp(final CreateUserDto createUserDto) {

    validateUser(createUserDto);

    User user = createUserDto.toEntity();
    userDao.createUser(user);
    return user.getId();
  }

  private void validateUser(CreateUserDto createUserDto) {
    String duplicateEmail = userDao.getEmail(createUserDto.getEmail());
    String duplicateLoginId = userDao.getLoginId(createUserDto.getLoginId());

    if (duplicateEmail != null) {
      throw new IllegalStateException("이미 존재하는 이메일 입니다");
    } else if (duplicateLoginId != null) {
      throw new IllegalStateException("이미 존재하는 아이디 입니다");
    }
  }
}
