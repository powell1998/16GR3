package com.qhit.lh.gr3.powell.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.powell.t7.bean.Emp;
import com.qhit.lh.gr3.powell.t7.service.BaseService;
import com.qhit.lh.gr3.powell.t7.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.powell.t7.utils.HibernateSessionFactory;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void getEmpByName() {
		// 获取session对象
		Session session = HibernateSessionFactory.getSession();

		// 通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class).add(
				Restrictions.like("empName", "%三"));

		// 通过criteria条件查询器进行查询
		List<Emp> list = criteria.list();

		// 遍历输出
		for (Emp emp : list) {
			System.out.println(emp.getEid() + ":" + emp.getEmpName());
		}
	}
}
