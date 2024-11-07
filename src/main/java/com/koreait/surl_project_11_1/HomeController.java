package com.koreait.surl_project_11_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Value("${custom.site.name}")
    private String customSiteName;

    @Value("${custom.secret.key}")
    private String secretKey;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "1234Main on " + customSiteName;
    }
    @GetMapping("/secretKey")
    @ResponseBody
    public String ShowSecretKey() {
        return "secretKey : " + secretKey;
    }
}