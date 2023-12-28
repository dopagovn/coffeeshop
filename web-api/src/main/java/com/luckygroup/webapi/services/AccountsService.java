package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import java.util.List;
import java.util.Optional;

public interface AccountsService {
  // Phuong thuc truu tuong
  Accounts findAccountById(Long id);
  List<Accounts> getAllAccount();
  Optional<Accounts> loginAccount(String email, String password);
  Accounts registerAccount(Accounts accounts);
  Accounts updateAccount(Accounts accounts);
}
