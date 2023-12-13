package com.luckygroup.webapi.repository;

import com.luckygroup.webapi.models.Accounts;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
  Accounts findByUsername(String username);
  Optional<Accounts> findById(Integer id);
=======
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
  Optional<Accounts> findById(Long id);
  Optional<Accounts> findByEmail(String email);
>>>>>>> thinh
}
