package com.poly.dao;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AccountDao {

	private EntityManager em = JpaUtil.getEntityManager();

	public List<Account> findAll() {
		String jpql = "SELECT a FROM Account a";
		TypedQuery<Account> query = em.createQuery(jpql, Account.class);
		List<Account> list = query.getResultList();
		return list;
	}
	
	public void create(Account account) {
		try {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
			e.printStackTrace(System.out);
		}
	}

	public void update(Account account) {
		try {
			em.getTransaction().begin();
			em.merge(account);
			em.getTransaction().commit();
			System.out.println("Cập nhật Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Cập nhật thất bại");
			e.printStackTrace(System.out);
		}
	}

	public void delete(String id) {
		try {
			em.getTransaction().begin();
			Account account = em.find(Account.class, id);
			em.remove(account);
			em.getTransaction().commit();
			System.out.println("Xoá Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Xoá Thất bại");
			e.printStackTrace(System.out);
		}
	}

	public Account findOne(String id) {
		Account account = em.find(Account.class, id);
		return account;
	}
	
	public Account findById(String username, String password) {
		Account users = new Account();
		try {
			em.getTransaction().begin();
			String jpql = "SELECT u FROM Account u WHERE u.username=:id AND u.matKhau=:pw";
			TypedQuery<Account> query = em.createQuery(jpql, Account.class);
			query.setParameter("id", username);
			query.setParameter("pw", password);
			users = query.getSingleResult();
			em.getTransaction().commit();
			System.out.println("Select Thành công");
			return users;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Select thất bại");
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new AccountDao().findById("phongtt", "phongtt").getTen());
	}
}
