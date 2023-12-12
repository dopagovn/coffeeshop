package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import java.util.List;

public interface AccountsService {
  // Functional
  Accounts getAccountById(Long id);
  List<Accounts> getAllAccount();
}
