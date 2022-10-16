package com.mustafakaplan.springbootaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String showMessage(String param) {
        System.out.println("Method showed message - param: " + param);
        return param;
    }
}
