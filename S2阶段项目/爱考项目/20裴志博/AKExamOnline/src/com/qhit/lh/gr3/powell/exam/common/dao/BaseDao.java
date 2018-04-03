package com.qhit.lh.gr3.powell.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.powell.exam.common.utils.HibernateSessionFactory;

public class BaseDao {
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}

}
