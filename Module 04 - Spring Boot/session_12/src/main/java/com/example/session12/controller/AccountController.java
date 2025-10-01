package com.example.session12.controller;

import com.example.session12.model.dto.request.AccountDTO;
import com.example.session12.model.dto.request.AccountLoginDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Account;
import com.example.session12.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<DataResponse<?>> register(@Valid @RequestBody AccountDTO accountDTO) {
        return accountService.register(accountDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<DataResponse<?>> login(@Valid @RequestBody AccountLoginDTO accountLoginDTO) {
        return accountService.login(accountLoginDTO);
    }
}
