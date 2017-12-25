package com.qhit.lh.gr3.powell.t6.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.powell.t6.dao.BaseDao;
import com.qhit.lh.gr3.powell.t6.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		// 1获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 2开启事务
		Transaction ts = session.beginTransaction();
		// 3执行
		session.save(obj);
		// 4提交事务
		ts.commit();
		// 5释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void delete(Object obj) {
		// 1获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 2开启事务
		Transaction ts = session.beginTransaction();
		// 3执行
		session.delete(obj);
		// 4提交事务
		ts.commit();
		// 5释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Object obj) {
		// 1获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 2开启事务
		Transaction ts = session.beginTransaction();
		// 3执行
		session.update(obj);
		// 4提交事务
		ts.commit();
		// 5释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public List<Object> getAll(String fromObject) {
		// 1获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 2开启事务
		Transaction ts = session.beginTransaction();
		// 3获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		// 4提交事务
		ts.commit();
		// 5释放资源
		HibernateSessionFactory.closeSession();
		return list;

	}

	@Override
	public Object getobjectById(Class clazz, int id) {
		// 1获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 2开启事务
		Transaction ts = session.beginTransaction();
		// 3执行
		Object obj = session.get(clazz, id);
		// 4提交事务
		ts.commit();
		// 5释放资源
		HibernateSessionFactory.closeSession();
		return obj;
	}

}
