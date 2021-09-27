package com.cozy.domain.user.service;

import com.cozy.domain.user.dao.UserDao;
import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public Long signUp(final CreateUserDto createUserDto) {

        String encodePassword = BCrypt.hashpw(createUserDto.getPassword(), BCrypt.gensalt(10));

        CreateUserDto dto = CreateUserDto.builder()
                .email(createUserDto.getEmail())
                .loginId(createUserDto.getLoginId())
                .phoneNumber(createUserDto.getPhoneNumber())
                .password(encodePassword)
                .build();

        return userDao.createUser(dto);
    }

    public GetOneUserDto getOneUser(final Long id) {
        return userDao.getOneUser(id);
    }
}
