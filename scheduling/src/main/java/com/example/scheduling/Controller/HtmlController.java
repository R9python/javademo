package com.example.scheduling.Controller;

import java.util.HashMap;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

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

    @RequestMapping("/scheduling/view")
    public String schedulingUser(HashMap<String, Object> map) {
        return "/view";
    }

    @RequestMapping(value="/scheduling/do/{userid}")
    public String doSchedule(@PathParam("userid")Long userid,HashMap<String, Object> map) {
        map.put("userid", userid);
        return "/doschedule";
    }
}