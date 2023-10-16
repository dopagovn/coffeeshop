package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsServices extends CrudRepository<Accounts, Integer> {}
