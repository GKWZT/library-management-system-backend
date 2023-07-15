package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.user.AccountUser;
import org.springframework.web.bind.annotation.*;

/**
 * @author wzt
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {


    @GetMapping("/me")
    public RestBean<AccountUser> me(@SessionAttribute("account") AccountUser user){
        // System.out.println("user:"+user);
        return RestBean.success(user);
    }



}
