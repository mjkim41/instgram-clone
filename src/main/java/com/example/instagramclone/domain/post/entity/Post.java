package com.example.instagramclone.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @EqualsAndHashCode @Builder
@NoArgsConstructor @AllArgsConstructor
public class Post {

    private Long id;
    private String content;
    private String writer;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
