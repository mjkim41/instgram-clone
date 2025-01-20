package com.example.instagramclone.service;

import com.example.instagramclone.domain.member.dto.response.MeResponse;
import com.example.instagramclone.domain.member.dto.response.ProfileHeaderResponse;
import com.example.instagramclone.domain.member.entity.Member;
import com.example.instagramclone.exception.ErrorCode;
import com.example.instagramclone.exception.MemberException;
import com.example.instagramclone.repository.MemberRepository;
import com.example.instagramclone.repository.PostRepository;
import com.example.instagramclone.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 개인 프로필 처리
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProfileService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final FileUploadUtil fileUploadUtil;

    /**
     * 로그인한 유저 정보를 반환하는 처리
     * @param username - 인증된 사용자 이름 (스프링 시큐리티에 의해 컨트롤러에서 받아옴)
     * @return 인증된 사용자의 프로필정보 (이름, 사용자계정, 프로필사진)
     */
    @Transactional(readOnly = true)   // SELECT만 하고 있을 경우
    public MeResponse getLoggedInUser(String username) {
        Member foundMember = getMember(username);

        return MeResponse.from(foundMember);
    }

    // 프로필 페이지 상단 헤더에 사용할 데이터 가져오기
    @Transactional(readOnly = true)
    public ProfileHeaderResponse getProfileHeader(String username) {

        // 사용자 이름에 매칭되는 회원정보 (프사, 이름, 사용자이름)
        Member foundMember = getMember(username);

        // 이 사용자가 작성한 피드의 수
        long feedCount = postRepository.countByMemberId(foundMember.getId());

        return ProfileHeaderResponse.of(foundMember, feedCount);
    }

    // 프로필 페이지 피드 목록에 사용할 데이터 처리
    @Transactional(readOnly = true)
    public List<ProfileHeaderResponse> findProfilePosts(String username) {
        Member foundMember = getMember(username);

        return postRepository.findProfilePosts(foundMember.getId());
    }

    private Member getMember(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(
                        () -> new MemberException(ErrorCode.MEMBER_NOT_FOUND)
                );
    }

    // 프로필 사진 처리
    public String updateProfileImage(MultipartFile profileImage, String username) {
        // 사진을 서버에 저장하기
        String uploadPath = fileUploadUtil.saveFile(profileImage);
        // DB 업데이트
        memberRepository.updateProfileImage(uploadPath, username);

        return uploadPath;
    }
}