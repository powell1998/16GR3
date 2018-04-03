package com.qhit.lh.gr3.powell.exam.common.dao;

import com.qhit.lh.gr3.powell.exam.common.bean.User;

public interface UserDao {
	
	/**
	 * @param user
	 * @return
	 * 登录业务
	 */
	public User login(User user); 

}
