package com.util.admin;


import com.util.admin.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//junit 외부의 실행자를 실행시켜서 스프링부트 테스트, junit 연결함.
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 빈 주입받음
    //웹 애플리케이션을 애플리케이션 서버에 배포하지 않고도
    //스프링 MVC의 동작을 재현할 수 있는 클래스
    private MockMvc mvc;//웹 api 테스트


    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //    /hello 주소로 http get 요청
                .andExpect(status().isOk())//http 헤더 상태 검증 200인지 아닌지
                .andExpect(content().string(hello)); //결과 검증 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name="hello";
        int amount=1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)//변수 설정 스트링만 됨
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())

                //json응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}