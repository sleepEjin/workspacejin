package com.kh.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ToiletService {

    private static final String API_URL = "http://openapi.seoul.go.kr:8088";

    public void getToiletList(int start, int end) {



        String url = String.format("%s/%s/")
    }
}
