package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.services.AccountsService;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/api/v1")
public class AccountsController {

  @Autowired
  private AccountsService accountsService;

  @GetMapping(path = "/account")
  public ResponseEntity<?> getAccountById(@RequestParam Integer id) {
    Optional<Accounts> accounts = accountsService.findById(id);

    if (accounts.isPresent()) {
      return ResponseEntity.ok(accounts.get());
    } else {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Account not found");
    }
  }

  @PostMapping(path = "/account/login")
  public ResponseEntity<String> login(
    @RequestBody Map<String, String> credentials
  ) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    if (accountsService.login(username, password)) {
      return ResponseEntity.ok("Login successful");
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
  }
}
