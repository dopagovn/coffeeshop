package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.services.AccountsServices;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1")
public class AccountsController {

  @Autowired
  private AccountsServices accountsServices;

  @GetMapping(path = "/accounts")
  public @ResponseBody Iterable<Accounts> getAllUser() {
    return accountsServices.findAll();
  }

  @GetMapping(path = "/account")
  public @ResponseBody Optional<Accounts> getUserById(
    @RequestParam Integer id
  ) {
    return accountsServices.findById(id);
  }

  @PostMapping(path = "/account/login")
  public @ResponseBody Map<Accounts, Object> login(
    @RequestBody String username,
    String password
  ) {
    Map<String, Object> response = new HashMap<>();

    return response;
  }
}
