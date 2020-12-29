package com.util.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//이 위치부터 스프링 부트의 자동설정, 스프링 빈 읽기 생성 자동설정
public class Application {//메인 클래스
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);//내장 와스
    }
}
