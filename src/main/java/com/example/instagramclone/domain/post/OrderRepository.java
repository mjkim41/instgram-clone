package com.example.instagramclone.domain.post;

import com.example.instagramclone.domain.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OrderRepository {

    // 회원정보 조회
    public List<Post> findAll();
}
