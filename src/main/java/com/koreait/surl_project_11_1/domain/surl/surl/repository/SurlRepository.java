package com.koreait.surl_project_11_1.domain.surl.surl.repository;

import com.koreait.surl_project_11_1.domain.surl.surl.entity.Surl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurlRepository extends JpaRepository<Surl, Long> {

}