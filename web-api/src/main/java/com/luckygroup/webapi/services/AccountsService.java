package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.repository.AccountsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

  private final AccountsRepository accountsRepository;

  public Optional<Accounts> findById(Integer id) {
    return accountsRepository.findById(id);
  }

  public List<Accounts> getAllAccount() {
    return accountsRepository.findAll();
  }

  public AccountsService(AccountsRepository accountsRepository) {
    this.accountsRepository = accountsRepository;
  }

  private Accounts findByUsername(String username) {
    return accountsRepository.findByUsername(username);
  }

  public boolean login(String username, String password) {
    Accounts account = findByUsername(username);
    if (account != null && account.getPassword().equals(password)) {
      return true;
    }
    return false;
  }
}
