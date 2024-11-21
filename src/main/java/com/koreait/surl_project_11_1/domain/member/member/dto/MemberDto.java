package com.koreait.surl_project_11_1.domain.member.member.dto;

import com.koreait.surl_project_11_1.domain.member.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberDto {
    private long id;
    private LocalDateTime crateDate;
    private LocalDateTime modifyDate;
    private String username;
    private String nickname;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.crateDate = member.getCreateDate();
        this.modifyDate = member.getModifyDate();
        this.username = member.getUsername();
        this.nickname = member.getNickname();
    }
}
