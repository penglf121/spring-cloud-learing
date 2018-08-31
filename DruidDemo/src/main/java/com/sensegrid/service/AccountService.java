package com.sensegrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sensegrid.bean.Account;
import com.sensegrid.interf.IAccountDAO;
import com.sensegrid.interf.IAccountService;
 
 
@Service
public class AccountService implements IAccountService {
    @Autowired
    @Qualifier("accountDaoImpl")
    private IAccountDAO accDaoImpl;
    public int add(Account account) {
        return accDaoImpl.add(account);
    }
 
    public int update(Account account) {
        return accDaoImpl.update(account);
    }
 
    public int delete(int id) {
        return accDaoImpl.delete(id);
    }
 
    public Account findAccountById(int id) {
        return accDaoImpl.findAccountById(id);
    }
 
    public List<Account> findAccountList() {
        return accDaoImpl.findAccountList();
    }
}
