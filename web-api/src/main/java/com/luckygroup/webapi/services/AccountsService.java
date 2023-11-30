package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.repository.AccountsRepository;
import com.luckygroup.webapi.services.HashPassword;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountsService {

  private final AccountsRepository accountsRepository;

  // Constructor
  public AccountsService(AccountsRepository accountsRepository) {
    this.accountsRepository = accountsRepository;
  }

  // Functional
  public Optional<Accounts> findById(Integer id) {
    return accountsRepository.findById(id);
  }

  public Optional<List<Accounts>> getAllAccount() {
    List<Accounts> accounts = accountsRepository.findAll();
    return Optional.ofNullable(accounts);
  }

  public Accounts findByUsername(String username) {
    return accountsRepository.findByUsername(username);
  }

  public boolean login(String username, String password) {
    Accounts account = findByUsername(username);
    if (account != null && account.getPassword().equals(password)) {
      return true;
    }
    return false;
  }

  public void register(Accounts accounts) {
    String hashedPassword = HashPassword.hashPassword(accounts.getPassword());
    accounts.setPassword(hashedPassword);
    accountsRepository.save(accounts);
  }
}
