package com.powell.t5.service.impl;

import java.util.List;

import com.powell.t5.bean.User;
import com.powell.t5.dao.UserDao;
import com.powell.t5.dao.impl.UserDaoImpl;
import com.powell.t5.service.UserService;

public class UserServiceImpl implements UserService {
	//声明一个全局的UserDao对象
	private UserDao userDao = new UserDaoImpl();

	@Override
	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	@Override
	public int upDateUser(User user) throws Exception {
		return userDao.upDateUser(user);
	}

	@Override
	public List<User> getAllUser() throws Exception {
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(User user) throws Exception {
		return userDao.getUserById(user);
	}

}
