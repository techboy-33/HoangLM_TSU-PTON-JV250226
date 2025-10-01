package com.example.session12.service;

import com.example.session12.model.constant.Role;
import com.example.session12.model.dto.request.AccountDTO;
import com.example.session12.model.dto.request.AccountLoginDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Account;
import com.example.session12.repository.AccountRepository;
import com.example.session12.security.jwt.JWTProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class AccountService {
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTProvider jwtProvider ;

    public ResponseEntity<DataResponse<?>> register(AccountDTO accountDTO) {
        Account account = Account.builder()
                .username(accountDTO.getUsername())
                .password(passwordEncoder.encode(accountDTO.getPassword()))
                .phoneNumber(accountDTO.getPhoneNumber())
                .fullName(accountDTO.getFullName())
                .role(Role.EMPLOYEE)
                .build();
        try {
            Account newAccount = accountRepository.save(account);
            DataResponse<Account> dataResponse = DataResponse
                    .<Account>builder()
                    .message("Register account successful")
                    .data(newAccount)
                    .status(201)
                    .build();
            return ResponseEntity.status(201).body(dataResponse);
        } catch (Exception e) {
            logger.error(e.getMessage());
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Register account failed: " + e.getMessage())
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(dataResponse);
        }
    }

    public ResponseEntity<DataResponse<?>> login(AccountLoginDTO accountLoginDTO) {
        Account account = accountRepository.findByUsername(accountLoginDTO.getUsername());
        if (account == null) {
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Login failed: Username or password is incorrect")
                    .status(400)
                    .build();
            logger.error(dataResponse.getMessage());
            return ResponseEntity.status(400).body(dataResponse);
        }
        if (passwordEncoder.matches(accountLoginDTO.getPassword(), account.getPassword())) {
            DataResponse<String> dataResponse = DataResponse
                    .<String>builder()
                    .message("Login successful")
                    .data("accessToken: " + jwtProvider.generateToken(account.getUsername()))
                    .status(200)
                    .build();
            return ResponseEntity.ok(dataResponse);
        } else {
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Login failed: Username or password is incorrect")
                    .status(400)
                    .build();
            logger.error(dataResponse.getMessage());
            return ResponseEntity.status(400).body(dataResponse);
        }
    }

    public Account findByUsername(String username){
        return accountRepository.findByUsername(username);
    }
}
