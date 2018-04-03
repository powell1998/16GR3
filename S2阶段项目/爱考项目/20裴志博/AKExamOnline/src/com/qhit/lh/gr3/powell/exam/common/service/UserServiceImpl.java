package com.qhit.lh.gr3.powell.exam.common.service;

import com.qhit.lh.gr3.powell.exam.common.bean.User;
import com.qhit.lh.gr3.powell.exam.common.dao.UserDao;
import com.qhit.lh.gr3.powell.exam.common.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
