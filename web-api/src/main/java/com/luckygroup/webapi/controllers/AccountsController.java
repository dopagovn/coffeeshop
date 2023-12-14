package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.services.AccountsService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
=======

>>>>>>> e6c7b7dc597c2d41c67652fae533c6d4d935b6cc
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
@RequestMapping(path = "/api/v1")
public class AccountsController {

  private AccountsService accountsService;

  @Autowired
  public AccountsController(AccountsService accountsService) {
    this.accountsService = accountsService;
  }

  @GetMapping(path = "/account/{id}")
  public ResponseEntity<Object> getAccountById(@PathVariable Long id) {
    try {
      Accounts accounts = accountsService.findAccountById(id);
      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Successful",
        accounts
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.NOT_FOUND,
        "Failed",
        null
      );
    }
  }

  @GetMapping(path = "/accounts")
  public ResponseEntity<Object> getAllAccount() {
    try {
      List<Accounts> accounts = accountsService.getAllAccount();
      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Successful",
        accounts
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Failed",
        null
      );
    }
  }

  @PostMapping("/account/login")
  public ResponseEntity<Object> loginAccount(@RequestBody Accounts accounts) {
    try {
      Optional<Accounts> account = accountsService.loginAccount(
        accounts.getEmail(),
        accounts.getPassword()
      );

      if (account.isPresent()) {
        return ResponseHandler.generateResponse(
          HttpStatus.OK,
          "Login success",
          account
        );
      }
      return ResponseHandler.generateResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Wrong password",
        null
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Cannot find account",
        null
      );
    }
  }

  @PostMapping("/account/register")
  public ResponseEntity<Object> registerAccount(
    @RequestBody Accounts accounts
  ) {
    try {
      Accounts account = accountsService.registerAccount(accounts);

      if (
        account.getEmail().isEmpty() ||
        account.getAddress().isEmpty() ||
        account.getBirthDate() == null ||
        account.getFirstName().isEmpty() ||
        account.getLastName().isEmpty() ||
        account.getPhone().isEmpty()
      ) {
        return ResponseHandler.generateResponse(
          HttpStatus.INTERNAL_SERVER_ERROR,
          "Vui lòng điền đầy đủ thông tin!",
          null
        );
      }

      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Đăng ký thành công!",
        account
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Cannot create account",
        null
      );
    }
  }
}
