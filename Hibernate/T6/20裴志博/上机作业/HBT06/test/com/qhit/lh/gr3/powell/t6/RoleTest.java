package com.qhit.lh.gr3.powell.t6;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t6.bean.Roles;
import com.qhit.lh.gr3.powell.t6.bean.UserInfo;
import com.qhit.lh.gr3.powell.t6.service.BaseService;
import com.qhit.lh.gr3.powell.t6.service.impl.BaseServiceImpl;

public class RoleTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		Roles roles = new Roles();
		roles.setRoleName("董事长");
		roles.setMemo("最高权力");
		
		UserInfo user1 = (UserInfo) baseService.getobjectById(UserInfo.class, 1);
		UserInfo user2 = (UserInfo) baseService.getobjectById(UserInfo.class, 4);
		
		roles.getUserinfo().add(user1);
		roles.getUserinfo().add(user2);
		
		baseService.add(roles);
	}
	@Test
	public void delete() {
		Roles roles = (Roles) baseService.getobjectById(Roles.class, 7);
		baseService.delete(roles);
	}
	@Test
	public void update() {
		Roles roles = (Roles) baseService.getobjectById(Roles.class, 9);
		roles.setMemo("你懂的");
		baseService.update(roles);
	}
	@Test
	public void query() {
		Roles roles = (Roles) baseService.getobjectById(Roles.class, 9);
		for(UserInfo userinfo : roles.getUserinfo()){
			System.out.println(roles.getRoleName()+":"+userinfo.getUserName());
		}
	}

}
