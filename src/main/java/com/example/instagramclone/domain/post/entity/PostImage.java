package com.example.instagramclone.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString @EqualsAndHashCode
@Builder @AllArgsConstructor @NoArgsConstructor
public class PostImage {

    private Long id;
    private Long postId;
    private String imageUrl;
    private int imageOrder;
    private LocalDateTime createdAt;

}
