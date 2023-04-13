package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Account;

public interface AccountService {

	List<Account> findAll();
	public void create(Account account);
	public void update(Account account);
	public void delete(String id);
	public Account findOne(String id);
	public Account findById(String username, String password);
}
