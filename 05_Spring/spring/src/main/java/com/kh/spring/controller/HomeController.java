package com.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(@RequestParam(value="cPage", defaultValue = "1") int currentPage) {
        //공중화장실 목록을 받아서 페이지에 전달
        //http://openapi.seoul.go.kr:8088/인증키/응답방식/mgisToiletPoi/시작인덱스/끝인덱스/
        http://openapi.seoul.go.kr:8088/454d5265796a696e38366463677754/json/mgisToiletPoi/1/5/

        //pageinfo를 사용해서 페이징 처리

        int itemLimit = 10;
        int pageLimit = 5;

        int startIndex = (currentPage - 1) * itemLimit + 1;
        int endIndex = startIndex * itemLimit;
        return "index";
    }
}
