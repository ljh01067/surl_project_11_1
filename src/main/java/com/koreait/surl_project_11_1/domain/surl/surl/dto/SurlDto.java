package com.koreait.surl_project_11_1.domain.surl.surl.dto;

import com.koreait.surl_project_11_1.domain.surl.surl.entity.Surl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SurlDto {
    private long id;
    private LocalDateTime crateDate;
    private LocalDateTime modifyDate;
    private long authorId;
    private String authorName;
    private String body;
    private String url;
    private long count;

    public SurlDto(Surl surl) {
        this.id = surl.getId();
        this.crateDate = surl.getCreateDate();
        this.modifyDate = surl.getModifyDate();
        this.authorId = surl.getAuthor().getId();
        this.authorName = surl.getAuthor().getName();
        this.body = surl.getBody();
        this.url = surl.getUrl();
        this.count = surl.getCount();
    }
}
