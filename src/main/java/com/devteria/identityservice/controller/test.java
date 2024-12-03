package com.devteria.identityservice.controller;

import com.devteria.identityservice.dto.request.ApiResponse;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {
    @Autowired
    UserService userService;
    //@PreAuthorize("hasRole('ROLE_USER') and hasAuthority('USER_PUT')")
    @GetMapping()
    String a(){
       // Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();

        //System.out.println();
        return "true";
    }
}
