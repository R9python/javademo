package com.example.scheduling.Controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * 本地访问内容地址 ：http://localhost:8080/scheduling
     * @param map
     * @return
     */
    @RequestMapping("/scheduling")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("desc", "前端HTML页面");
        return "/index";
    }
}