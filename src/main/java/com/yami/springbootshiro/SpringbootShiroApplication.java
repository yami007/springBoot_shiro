package com.yami.springbootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yami.springbootshiro.dao")
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroApplication.class, args);
	}

}
