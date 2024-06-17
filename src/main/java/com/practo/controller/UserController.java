package com.practo.controller;

import com.practo.entity.User;
import com.practo.payload.LoginDto;
import com.practo.payload.TokenResponse;
import com.practo.payload.UserDto;
import com.practo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String>  signUp(@RequestBody UserDto userDto){
        User users = userService.addUser(userDto);
        if (users!=null){
            return new ResponseEntity<>("Registration Successfull", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        String token = userService.verifyLogin(loginDto);
        if (token!=null){
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid User",HttpStatus.UNAUTHORIZED);
    }
}
