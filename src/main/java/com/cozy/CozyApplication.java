package com.cozy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication은 @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 등을 래핑한다.
 * @SpringBootConfiguration은 @Configuration과 동일한 역할을 수행한다.
 * @EnableAutoConfiguration은 스프링이 기본적으로 지정해 놓은 Configuration내의 빈들을 자동 등록하는 역할을 수행한다.
 * @ComponentScan은 해당 어노테이션이 적용된 패키지 기준 하위 패키지들에 정의된 @Component 혹은
 * streotype인 @Controller, @Service @Repository 가 부여된 모든 클래스들을 자동으로 스캔하여 Bean으로 등록해주는 역할을 수행한다.
 */

@Slf4j
@SpringBootApplication
public class CozyApplication {

  public static void main(String[] args) {
    SpringApplication.run(CozyApplication.class, args);
  }

}
