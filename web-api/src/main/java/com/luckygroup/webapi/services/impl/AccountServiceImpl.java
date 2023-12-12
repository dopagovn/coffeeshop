package com.luckygroup.webapi.services.impl;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.repository.AccountsRepository;
import com.luckygroup.webapi.services.AccountsService;
import java.util.List;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Accounts getAccountById(Long id) throws ResourceAccessException {
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
      return (List<Accounts>) modelMapper.map(accounts, Accounts.class);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found account", e);
    }
  }
}
