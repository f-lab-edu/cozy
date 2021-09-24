package com.cozy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @SpringBootTest는 테스트에 사용할 ApplicationContext를 생성하고 빈들을 불러오는 역할을 수행한다.
 * @SpringBootTest를 별다른 옵션을 지정하지 않고 이용하면 해당 애플리케이션 상에 정의된 모든 빈을 ApplicationContext로 불러온다.
 * 또한, classes 옵션을 이용해 빈을 생성할 @Configuration 클래스를 직접 지정할 수도 있다.
 */

@SpringBootTest
class CozyApplicationTests {

  @Test
  void contextLoads() {
  }

}
