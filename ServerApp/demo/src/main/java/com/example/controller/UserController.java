package com.example.controller;

import com.example.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @GetMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getUserName().equals("user") && user.getPassword().equals("password");
    }


}