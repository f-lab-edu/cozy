package com.cozy;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MySQLConnectionTest {

  /**
   * @Autowired?
   * 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입한다.
   * 만약 의존 객체의 타입을 찾지 못한다면, 변수명과 빈 이름이 일치하는 빈을 주입한다.
   * 의존 객체의 타입이 여러가지라면, 빈이 주입되지 않는다.
   * 다만, @Primary 또는 @Qualifier 어노테이션을 적절히 사용하면 의존 객체의 타입이 여러가지여도 빈을 주입 받을 수 있다.
   */
  @Autowired
  private SqlSessionFactory sqlSessionFactory;

  @Test
  public void MySQL_연동테스트() {

    try (Connection con = sqlSessionFactory.openSession().getConnection()) {
      assertFalse(con.isClosed());
    } catch (Exception e) {
      fail();
    }
  }
}
