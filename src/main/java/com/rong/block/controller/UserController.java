package com.rong.block.controller;

import com.rong.block.pojo.User;
import com.rong.block.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Controller
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        try {
            userService.addUser(user);
            return "redirect:ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
