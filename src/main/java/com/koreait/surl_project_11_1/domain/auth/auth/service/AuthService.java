package com.koreait.surl_project_11_1.domain.auth.auth.service;

import com.koreait.surl_project_11_1.domain.member.member.entity.Member;
import com.koreait.surl_project_11_1.domain.surl.surl.entity.Surl;
import com.koreait.surl_project_11_1.global.exceptions.GlobalException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public void checkCanGetSurl(Member actor, Surl surl) {
        if(!canGetSurl(actor,surl)){
            throw new GlobalException("403-1","권한이 없어");
        }
    }

    private boolean canGetSurl(Member actor, Surl surl) {
        if(actor == null) return false;
        if(surl == null) return false;

        return actor.equals(surl.getAuthor());
    }

    public void checkCanDeleteSurl(Member actor, Surl surl) {
        if (!canDeleteSurl(actor, surl))
            throw new GlobalException("403-1", "권한이 없어");
    }

    private boolean canDeleteSurl(Member actor, Surl surl) {
        return canGetSurl(actor, surl);
    }

    public void checkCanModifySurl(Member actor, Surl surl) {
        if (!canModifySurl(actor, surl))
            throw new GlobalException("403-1", "권한이 없어");
    }

    private boolean canModifySurl(Member actor, Surl surl) {
        return canGetSurl(actor, surl);
    }
}
