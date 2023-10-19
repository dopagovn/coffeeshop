package com.luckygroup.webapi.repository;

import com.luckygroup.webapi.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
  Accounts findByUsername(String username);
}
