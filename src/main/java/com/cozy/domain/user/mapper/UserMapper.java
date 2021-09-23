package com.cozy.domain.user.mapper;

import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  Long createUser(CreateUserDto createUserDto);

  GetOneUserDto getOneUser(Long id);
}
