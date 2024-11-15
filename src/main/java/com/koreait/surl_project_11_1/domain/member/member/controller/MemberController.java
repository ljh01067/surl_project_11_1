package com.koreait.surl_project_11_1.domain.member.member.controller;

import com.koreait.surl_project_11_1.domain.member.member.service.MemberService;
import com.koreait.surl_project_11_1.global.exceptions.GlobalException;
import com.koreait.surl_project_11_1.global.reData.RsData;
import com.koreait.surl_project_11_1.standard.util.Ut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    @ResponseBody
    public RsData join(String username, String password, String nickname){
        if(Ut.str.isBlank(username)){
            throw new GlobalException("400-1","username을 입력해");
        }
        if(Ut.str.isBlank(password)){
            throw new GlobalException("400-2","password을 입력해");
        }
        if(Ut.str.isBlank(nickname)){
            throw new GlobalException("400-3","nickname을 입력해");
        }
        return memberService.join(username,password,nickname);
    }
}