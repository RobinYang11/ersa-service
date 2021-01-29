package com.ersa.sso.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCtrl {

    @GetMapping("/login")
    String login(){
        return "login";
    }
}
