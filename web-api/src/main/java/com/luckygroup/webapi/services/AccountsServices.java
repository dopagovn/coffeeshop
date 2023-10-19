package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountsServices extends CrudRepository<Accounts, Integer> {
  AccountRepo
  Optional<Accounts> findById(Integer id);


  private Accounts findByUsername(String username){
    return account.findByUsername(username);
  }

  public boolean login(
    String useranme,
    String password
  ){
    Accounts account = findByUsername(username);
    
  };
}
