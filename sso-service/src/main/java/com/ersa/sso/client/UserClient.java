package com.ersa.sso.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("user-service")
public interface UserClient {

    @PostMapping("queryUser")
    Object queryUser();

}
