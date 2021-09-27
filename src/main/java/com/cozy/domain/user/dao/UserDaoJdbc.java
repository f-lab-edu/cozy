package com.cozy.domain.user.dao;

import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import com.cozy.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoJdbc implements UserDao {

    private final UserMapper userMapper;

    @Override
    public Long createUser(CreateUserDto createUserDto) {
        return userMapper.createUser(createUserDto);
    }

    @Override
    public GetOneUserDto getOneUser(Long id) {
        return userMapper.getOneUser(id);
    }
}
