package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.services.AccountsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
      Accounts accounts = accountsService.getAccountById(id);
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
}
