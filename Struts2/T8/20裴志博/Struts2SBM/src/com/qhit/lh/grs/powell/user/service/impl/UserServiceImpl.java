package com.qhit.lh.grs.powell.user.service.impl;

import java.util.List;

import com.qhit.lh.grs.powell.user.bean.User;
import com.qhit.lh.grs.powell.user.dao.UserDao;
import com.qhit.lh.grs.powell.user.dao.impl.UserDaoImpl;
import com.qhit.lh.grs.powell.user.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	public User doLogin(String userName,String userPassword){
		return userDao.doLogin(userName, userPassword);
	}

	public int addUser(User user) {
		return userDao.addUser(user);
	}

	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

}
