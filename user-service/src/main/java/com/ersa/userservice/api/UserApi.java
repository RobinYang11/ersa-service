package com.ersa.userservice.api;

import com.ersa.userservice.bean.UserBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @PostMapping("queryUser")
    Object queryUser(){
        UserBean user = new UserBean();
        user.setId(1).setName("robin").setNickName("badou");
        return  user;
    }
}
