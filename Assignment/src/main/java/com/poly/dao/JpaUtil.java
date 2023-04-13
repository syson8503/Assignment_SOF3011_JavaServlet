package com.poly.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	static public EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("SOF_Assignment");
		}
		System.out.println("Connect");
		return factory.createEntityManager();
	}

	static public void closeConnect() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
