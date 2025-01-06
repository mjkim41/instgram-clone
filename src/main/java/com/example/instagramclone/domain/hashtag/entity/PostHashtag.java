package com.example.instagramclone.domain.hashtag.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostHashtag {

    private Long id;          // Primary Key
    private Long postId;      // Foreign Key (Post 테이블의 id)
    private Long hashtagId;   // Foreign Key (Hashtag 테이블의 id)
    private LocalDateTime createdAt; // 생성 시각 (타임스탬프 형태)

}
