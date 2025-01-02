package com.example.instagramclone.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode @Builder @NoArgsConstructor @AllArgsConstructor
public class PostCreate {

    @NotBlank(message = "작성자 정보는 필수입니다")
    private String writer;

    @Size(max = 2200, message = "피드 내용은 최대 2200자 까지 입력 가능합니다.")
    private String content;


}
