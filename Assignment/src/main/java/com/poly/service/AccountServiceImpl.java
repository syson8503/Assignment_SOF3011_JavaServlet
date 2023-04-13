package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDao dao = new AccountDao();
	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}
	@Override
	public void create(Account account) {
		dao.create(account);
	}
	@Override
	public void update(Account account) {
		dao.update(account);
	}
	@Override
	public void delete(String id) {
		dao.delete(id);
	}
	@Override
	public Account findOne(String id) {
		
		return dao.findOne(id);
	}
	@Override
	public Account findById(String username, String password) {
		
		return dao.findById(username, password);
	}

}
