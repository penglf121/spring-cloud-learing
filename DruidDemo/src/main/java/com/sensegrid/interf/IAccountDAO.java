package com.sensegrid.interf;


import java.util.List;

import com.sensegrid.bean.Account;
 
public interface IAccountDAO {
	int add(Account account);
 
	int update(Account account);
 
	int delete(int id);
 
	Account findAccountById(int id);
 
	List<Account> findAccountList();

}