package com.example.instagramclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
// 스프링 security library를 사용할 건데, 이 클래스에서 자동으로 생성되는 빈처럼 설정을 변경해서 쓸 거야.
// 1. 일단 스프링이 시작되면 @bean이 붙은 메소드를 호출해서 리턴값을 스프링에 빈으로 등록할 건데,
//    @bean이 있다는 걸 알려주기 위해 클래스에 @Configuration이랑  @EnableWebSecurity를 붙여 줄게
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    // @bean 붙였으니까 스프링 시작되면 이 메소드 호출에서 리턴값 spring 관리 bean으로 등록해줘
    @Bean
    // SecurityFilterCHain 인터페이스에 있는 filterCHain메소드를 오버라이딩 해 줄께
    // 참고로 여기는 httpSecurity가 parameter로 들어가는데, 이건 스프링 시작되면 자동으로 생성될 거야
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 커스텀 보안 설정
        http
                .csrf(csrf -> csrf.disable()) // csrf : cross-site request forgery를 비활성화
                .cors(cors -> cors.configure(http)) // CORS 설정의 기본값은 기본적으로 모든 출처에 대한 요청을 허용하지 않습니다. 즉, 클라이언트가 다른 출처에서 요청을 보낼 경우 기본적으로 차단됩니다.
                ;

        return http.build();
    }



}
