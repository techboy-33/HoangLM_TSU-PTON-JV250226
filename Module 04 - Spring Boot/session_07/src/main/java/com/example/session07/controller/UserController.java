package com.example.session07.controller;

import com.example.session07.model.dto.UserDTO;
import com.example.session07.model.entity.User;
import com.example.session07.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        User user = userService.register(userDTO);
        if (user != null) {
            return new ResponseEntity<>(user , HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("register failed !",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpSession session) {
        User user = userService.login(userDTO.getUsername(), userDTO.getPassword(),session);
        if (user != null) {
            return new ResponseEntity<>("login successfully !" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("login failed !",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
       userService.logout(session);
        return new ResponseEntity<>("logout success !",HttpStatus.OK);
    }

}
