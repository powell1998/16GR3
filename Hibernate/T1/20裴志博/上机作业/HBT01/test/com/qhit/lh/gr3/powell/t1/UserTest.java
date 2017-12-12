/**
 * 
 */
package com.qhit.lh.gr3.powell.t1;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t1.bean.User;
import com.qhit.lh.gr3.powell.t1.service.BaseService;
import com.qhit.lh.gr3.powell.t1.service.impl.BaseServiceImpl;

/**
 * @author 裴志博 TODO 2017年12月11日上午11:51:46
 */
public class UserTest {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add() {
		User user = new User("小红", "123456", "1995-01-02", "男", 1);
		bs.add(user);
	}

	@Test
	public void delete() {
		// 声明并实例化对象
		User user = new User();
		user.setId(4);
		// 操作对象
		bs.delete(user);
	}

	@Test
	public void update() {
		// 声明并实例化对象
		User user = new User();
		user.setId(5);
		user.setUname("funcation");
		user.setUpwd("6666");
		user.setBirthday("2017-12-11");
		user.setSex("m");
		user.setEnable(1);
		// 数据操作
		bs.update(user);

	}

	@Test
	public void getAll() {
		List<Object> list =  bs.getAll("from User");
		for (Object object : list) {
			User user = (User) object;
			System.out.println(user.toString());

	}

}
}
