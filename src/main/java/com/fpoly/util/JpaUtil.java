package com.fpoly.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fpoly.entity.User;

public class JpaUtil {
	
	//static EntityManagerFactory emf = null;
	//static EntityManager em = null;
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEM() {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOOE");
		//EntityManager em = emf.createEntityManager();
		//return Persistence.createEntityManagerFactory("PolyOE").createEntityManager();
		if (emf == null || !emf.isOpen())
			emf = Persistence.createEntityManagerFactory("oe");
		return emf.createEntityManager();
	}
	public static void destroy() {
		//em.close();
		//emf.close();
		if (emf != null && emf.isOpen())
			emf.close();
		emf = null;
	}
}
