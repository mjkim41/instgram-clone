package com.example.instagramclone.domain.post.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.ibatis.annotations.Property;

@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @Builder
public class PostImageResponse {

    @JsonProperty("image_id")
    private Long id;
    private String imageUrl;
    private int imageOrder;

}
