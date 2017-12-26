package com.qhit.lh.gr3.powell.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t7.bean.Emp;
import com.qhit.lh.gr3.powell.t7.service.BaseService;
import com.qhit.lh.gr3.powell.t7.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void getEmpByName() {
		List<Emp> list = baseService.getEmpByName("%三%");
		
		for(Emp emp : list){
			System.out.println(emp.getEid()+":"+emp.getEmpName());
		}
	}

}
