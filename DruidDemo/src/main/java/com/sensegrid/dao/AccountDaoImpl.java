package com.sensegrid.dao;

import com.alibaba.druid.support.http.StatViewServlet;
import com.sensegrid.bean.Account;
import com.sensegrid.interf.IAccountDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
 
import java.util.List;
 
@Repository
@Configuration
@Component
public class AccountDaoImpl implements IAccountDAO {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
   
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name, money) values(?, ?)",
              account.getName(),account.getMoney());
 
    }
 
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE  account SET NAME=? ,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }
 
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            Account account = list.get(0);
            return account;
        }else{
            return null;
        }
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
