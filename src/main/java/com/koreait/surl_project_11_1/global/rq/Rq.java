package com.koreait.surl_project_11_1.global.rq;

import com.koreait.surl_project_11_1.domain.member.member.entity.Member;
import com.koreait.surl_project_11_1.domain.member.member.service.MemberService;
import com.koreait.surl_project_11_1.global.exceptions.GlobalException;
import com.koreait.surl_project_11_1.standard.util.Ut;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final MemberService memberService;
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    private Member member;

//    @Getter
//    @Setter
//    private Member member;
        public Member getMember() {
            if(member != null) return member; // 메모리 캐싱
            
            String actorUsername = req.getParameter("actorUsername");
            String actorPassword = req.getParameter("actorPassword");

            if(Ut.str.isBlank(actorUsername)) throw new GlobalException("401-1","인증정보(아이디) 입력해줘");
            if(Ut.str.isBlank(actorPassword)) throw new GlobalException("401-2","인증정보(비밀번호) 입력해줘");

            Member loginedMember = memberService.findByUsername(actorUsername).orElseThrow(() -> new GlobalException("401-3", "해당회원은 없어"));
            if(!loginedMember.getPassword().equals(actorPassword)) throw new GlobalException("401-4","비밀번호 틀림");

            member = loginedMember;

            return loginedMember; // user1
    }
    public String getCurrentUrlPath() {
        return req.getRequestURI();
    }
    public void setStatusCode(int statusCode) {
        resp.setStatus(statusCode);
    }
}
