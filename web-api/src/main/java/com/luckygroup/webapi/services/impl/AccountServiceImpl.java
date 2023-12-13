package com.luckygroup.webapi.services.impl;

// import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.repository.AccountsRepository;
import com.luckygroup.webapi.services.AccountsService;
import com.luckygroup.webapi.services.HashPassword;
import java.util.List;
import java.util.Optional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class AccountServiceImpl implements AccountsService {

  private final AccountsRepository accountsRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public AccountServiceImpl(
    AccountsRepository accountsRepository,
    ModelMapper modelMapper
  ) {
    this.accountsRepository = accountsRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Accounts findAccountById(Long id) throws ResourceAccessException {
    try {
      Accounts accounts = accountsRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not Found Account"));
      return modelMapper.map(accounts, Accounts.class);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found account", e);
    }
  }

  @Override
  public List<Accounts> getAllAccount() throws ResourceAccessException {
    try {
      List<Accounts> accounts = accountsRepository.findAll();
      return accounts;
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found account", e);
    }
  }

  @Override
  public Optional<Accounts> loginAccount(String email, String password) {
    try {
      Optional<Accounts> accounts = accountsRepository.findByEmail(email);
      if (accounts != null) {
        Accounts account = accounts.get();

        Boolean checkPassword = HashPassword.comparePassword(
          password,
          account.getPassword()
        );
        if (checkPassword) {
          return accounts;
        }
      }
      return Optional.empty();
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found account", e);
    }
  }

  @Override
  public Accounts registerAccount(Accounts accounts) {
    try {
      String hashedPassword = HashPassword.hashPassword(accounts.getPassword());
      accounts.setPassword(hashedPassword);

      accounts = accountsRepository.save(accounts);

      return accounts;
    } catch (Exception e) {
      throw new ResourceNotFoundException("Failed to register account", e);
    }
  }

  @Override
  public Accounts updateAccount(Accounts accounts) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
  }
}
