package com.cozy.domain.user;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class User {

  private final Long id;
  private final String loginId;
  private final String password;
  private final String email;
  private final String phoneNumber;
  private final LocalDateTime createdAt;
  private final LocalDateTime deletedAt;
  private final Boolean isDeleted;
}
