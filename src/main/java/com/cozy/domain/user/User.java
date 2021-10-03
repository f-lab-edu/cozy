package com.cozy.domain.user;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import org.apache.ibatis.type.Alias;

/**
 * @Value? Value 어노테이션은 불변 객체를 만들어 주는 역할을 한다. 클래스를 final로 필드를 private, final로 만들어준다. 그리고
 * @AllArgConstructor, @ToString, @EqualsAndHashCode 어노테이션을 가지고 있다.
 */
@Value
@Alias("User")
@Builder
@ToString
public class User {

  Long id;
  String loginId;
  String password;
  String email;
  String phoneNumber;
  LocalDateTime createdAt;
  LocalDateTime deletedAt;
  LocalDateTime updatedAt;
  Boolean isDeleted;

}
