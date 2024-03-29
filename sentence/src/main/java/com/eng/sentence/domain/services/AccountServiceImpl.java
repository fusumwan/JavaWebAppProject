package com.eng.sentence.domain.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.utils.web.WebRequestUtil;
import com.eng.sentence.domain.models.repositories.*;
import com.eng.sentence.domain.models.*;

@Service
public class AccountServiceImpl implements AccountService {
	// need to inject account Dao
	@Autowired
	private AccountDao accountDao;
	/*
	* When using a Spring-based transaction management mechanism (such as using the @Transactional annotation), Spring will automatically handle the opening and closing of the Session.
	*/
	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDao.getAccounts();
	}
	
	@Override
	@Transactional
	public Account saveAccount(Account account) {
		return accountDao.saveAccount(account);
	}
	
	@Override
	@Transactional
	public Account getAccount(String account_id) {
		return accountDao.getAccount(account_id);
	}
	
	@Override
	@Transactional
	public void deleteAccount(String account_id) {
		accountDao.deleteAccount(account_id);
	}
	@Override
	@Transactional
	public List<Account> findByAccountId(String account_id){
		return accountDao.findByAccountId(account_id);
	}
	@Override
	@Transactional
	public List<Account> findByFirstName(String first_name){
		return accountDao.findByFirstName(first_name);
	}
	@Override
	@Transactional
	public List<Account> findByLastName(String last_name){
		return accountDao.findByLastName(last_name);
	}
	@Override
	@Transactional
	public List<Account> findByUsername(String username){
		return accountDao.findByUsername(username);
	}
	@Override
	@Transactional
	public List<Account> findByEmail(String email){
		return accountDao.findByEmail(email);
	}
	@Override
	@Transactional
	public List<Account> findByContactNumber(String contact_number){
		return accountDao.findByContactNumber(contact_number);
	}
	@Override
	@Transactional
	public List<Account> findByPassword(String password){
		return accountDao.findByPassword(password);
	}
	@Override
	@Transactional
	public List<Account> findByUserType(String user_type){
		return accountDao.findByUserType(user_type);
	}
	@Override
	@Transactional
	public List<Account> filterAccount(WebRequestUtil.FilterRequestData requestData){
		return accountDao.filterAccount(requestData);
	}
	@Override
	@Transactional
	public List<Account> getByAccountUsernamePassword(
	String username_00,
	String password_01
	){
		return accountDao.getByAccountUsernamePassword(username_00,password_01);
	}
	@Override
	@Transactional
	public List<Account> getByAccountUsername(
	String username_00
	){
		return accountDao.getByAccountUsername(username_00);
	}
	@Override
	@Transactional
	public List<Account> getByAccount(
	
	){
		return accountDao.getByAccount();
	}
	
}
