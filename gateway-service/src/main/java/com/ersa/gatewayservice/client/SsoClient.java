package com.ersa.gatewayservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("sso-service")
public interface SsoClient {

    @PostMapping("/setKey")
    void setKey(@RequestParam("key") String key, @RequestParam("value")  String value);

    @PostMapping("/hasKey")
    boolean hasKey(@RequestParam  String key);

    @PostMapping("/getKey")
    String getKey(@RequestParam  String key);
}
