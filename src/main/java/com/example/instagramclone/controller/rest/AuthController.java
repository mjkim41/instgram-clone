package com.example.instagramclone.controller.rest;

import com.example.instagramclone.domain.member.dto.request.LoginRequest;
import com.example.instagramclone.domain.member.dto.request.SignUpRequest;
import com.example.instagramclone.domain.member.dto.response.DuplicateCheckResponse;
import com.example.instagramclone.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        log.info("request for signup: {}", signUpRequest.getUsername());
        memberService.signUp(signUpRequest);

        return ResponseEntity
                .ok()
                .body(Map.of(
                        "message", "회원가입이 완료되었습니다.",
                        "username", signUpRequest.getUsername()
                ));
    }

    // 중복확인을 검사하는 API
    @GetMapping("/check-duplicate")
    public ResponseEntity<DuplicateCheckResponse> checkDuplicate(
            @RequestParam String type,
            @RequestParam String value
    ) {
        log.info("check duplicate type: {}, value: {}", type, value);

        DuplicateCheckResponse responseDto = memberService.checkDuplicate(type, value);

        return ResponseEntity.ok().body(responseDto);
    }

    // 로그인 검증 API
    // GET 방식은 정보를 보낼 떄 ?로 보내는데, 그럼 보안상 좋지 않으므로
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid LoginRequest loginRequest) {

        log.info("request for login: {}", loginRequest.getUsername());

        Map<String, Object> responseMap = memberService.authenticate(loginRequest);

        return ResponseEntity.ok().body(responseMap);
    }

}
