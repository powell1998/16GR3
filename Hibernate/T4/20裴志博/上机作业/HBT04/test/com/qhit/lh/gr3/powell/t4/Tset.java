/**
 * 
 */
package com.qhit.lh.gr3.powell.t4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t4.bean.Dept;
import com.qhit.lh.gr3.powell.t4.bean.Emp;
import com.qhit.lh.gr3.powell.t4.bean.UserInfo;
import com.qhit.lh.gr3.powell.t4.service.BaseService;
import com.qhit.lh.gr3.powell.t4.service.impl.BaseServiceImpl;

/**
 * @author 裴志博 TODO 2017年12月18日上午9:06:18
 */
public class Tset {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		// 创建部门
		Dept dept = new Dept();
		dept.setDeptName("裴氏集团");
		dept.setAddress("开封");
		// 没有员工

		// 有新员工
		Emp dwj = new Emp();
		dwj.setEmpName("董文君");
		dwj.setEmpSex("男");

		Emp wjw = new Emp();
		wjw.setEmpName("王军伟");
		wjw.setEmpSex("男");

		dept.getEmps().add(wjw);
		dept.getEmps().add(dwj);
		// do
		baseService.add(dept);
	}

	@Test
	public void delete() {
		Dept dept = (Dept) baseService.getobjectById(Dept.class, 1);
		baseService.delete(dept);

	}

	@Test
	public void update() {
		Dept dept = (Dept) baseService.getobjectById(Dept.class, 1);
		dept.setDeptName("裴氏全球控股集团");
		
		baseService.update(dept);
	}

	@Test
	public void query() {
		Dept dept = (Dept) baseService.getobjectById(Dept.class, 1);

		for (Emp emp : dept.getEmps()) {
			System.out.println(dept.getDeptName() + ":" + emp.getEmpName());
		}

	}

}
