package com.koreait.surl_project_11_1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SurlProject111Application {
    public static void main(String[] args) {
        SpringApplication.run(SurlProject111Application.class, args);
    }
}