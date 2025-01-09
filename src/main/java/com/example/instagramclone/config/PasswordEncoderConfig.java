package com.example.instagramclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // @cONFIGURATION : 스프링 시작되면 이 클래스에 있는 @Bean밑에 있는 메소드 호출해서 리턴값 bean으로 등록해죠!
public class PasswordEncoderConfig {

    @Bean
    // PasswordEncoder 인터페이스 있는 passwordEncoder() 오버라이딩
    public PasswordEncoder passwordEncoder() {
        // BCrapy방식의 PasswordEncoder()를  불러와줘.
        return new BCryptPasswordEncoder();
    }
}
