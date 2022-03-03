package com.lwx.client;

import com.lwx.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("lwx-user-service")
public interface UserClient {

    @GetMapping("getUserById/{id}")
    User getUser(@PathVariable("id") int id);

}
