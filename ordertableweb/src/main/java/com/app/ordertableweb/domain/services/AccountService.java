package com.app.ordertableweb.domain.services;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

import com.app.ordertableweb.domain.models.*;
import com.app.ordertableweb.domain.utils.web.WebRequestUtil;
public interface AccountService {
	public List<Account> getAccounts();
	public Account saveAccount(Account account);
	public Account getAccount(String account_id);
	public void deleteAccount(String account_id);
	public List<Account> findByAccountId(String account_id);
	public List<Account> findByFirstName(String first_name);
	public List<Account> findByLastName(String last_name);
	public List<Account> findByUsername(String username);
	public List<Account> findByEmail(String email);
	public List<Account> findByContactNumber(String contact_number);
	public List<Account> findByPassword(String password);
	public List<Account> findByUserType(String user_type);
	public List<Account> filterAccount(WebRequestUtil.FilterRequestData requestData);
	public List<Account> getByAccountUsername(String username_01);
	public List<Account> getByAccount();
}
