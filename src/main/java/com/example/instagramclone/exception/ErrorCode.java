package com.example.instagramclone.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// API에서 나오는 여러가지 에러상황들을 상수로 표현
@RequiredArgsConstructor
@Getter
public enum ErrorCode {

      /* [한 파일에 여러 Custom Exception을 만드는 방법]
       - ENUM 클래스를 만들고, 각 Exception을 상수(일종의 객체로 보면 됨)으로 만들고,
         이 떄 Exception의 생성자로 필요한 필드인 errorMessage와 HttpStatus를 적어준다.
     */

    // 알 수 없는 서버오류
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류입니다. 점검 후 조치하겠습니다."),
    ;

    private final HttpStatus status;
    private final String message;


}
