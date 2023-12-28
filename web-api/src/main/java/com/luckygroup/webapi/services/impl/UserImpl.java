package com.luckygroup.webapi.services.impl;

import java.util.List;
import java.util.Optional;

import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.services.AccountsService;
public class UserImpl implements AccountsService {

    @Override
    public Accounts findAccountById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAccountById'");
    }

    @Override
    public List<Accounts> getAllAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAccount'");
    }

    @Override
    public Optional<Accounts> loginAccount(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginAccount'");
    }

    @Override
    public Accounts registerAccount(Accounts accounts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerAccount'");
    }

    @Override
    public Accounts updateAccount(Accounts accounts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }
    
}
