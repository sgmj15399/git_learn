package com.example.demo;


import com.example.demo.model.User;
import com.example.demo.proxy.RpcClient;
import com.example.demo.proxy.RpcClientJdk;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mj
 */
@Slf4j
public class MyClientApplication {

    public static void main(String[] args) {

        RpcClient jdk = new RpcClientJdk();
        UserService userService = jdk.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        if (user == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println("find user id=1 from server: " + user.getName());

    }

}
