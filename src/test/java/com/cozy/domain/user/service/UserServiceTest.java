package com.cozy.domain.user.service;

import com.cozy.domain.user.dto.CreateUserDto;
import com.cozy.domain.user.dto.GetOneUserDto;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void signUp() {

        // given
        String decodePassword = "1234";

        CreateUserDto dto = CreateUserDto.builder()
                .email("cozy@gmail.com")
                .loginId("cozy")
                .phoneNumber("01012345678")
                .password(decodePassword)
                .build();


        // when
        Long id = userService.signUp(dto);
        GetOneUserDto user = userService.getOneUser(id);

        // then
        assertEquals(dto.getEmail(), user.getEmail());
        assertEquals(dto.getLoginId(), user.getLoginId());
        assertEquals(dto.getPhoneNumber(), user.getPhoneNumber());
        assertTrue(BCrypt.checkpw(decodePassword, user.getPassword()));
    }
}