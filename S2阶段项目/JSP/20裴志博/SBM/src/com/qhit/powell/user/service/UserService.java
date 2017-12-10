package com.qhit.powell.user.service;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.user.bean.User;
import com.qhit.powell.user.dao.UserDao;

public class UserService implements IUserService {
	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.service.IUserService#doLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User doLogin(String userName,String userPassword){
		return new UserDao().doLogin(userName, userPassword);
	}

	@Override
	public int addUser(User user) {
		return new UserDao().addUser(user);
	}

	@Override
	public PageBean getPageBean(PageBean pagebean) {
		// TODO Auto-generated method stub
		return new UserDao().getPageBean(pagebean);
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return new UserDao().delUser(userId);
	}

	@Override
	public int updUser(int userId) {
		// TODO Auto-generated method stub
		return new UserDao().updUser(userId);
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return new UserDao().getUserById(userId);
	}

	@Override
	public int updUserpwd(User user, int userId) {
		// TODO Auto-generated method stub
		return new UserDao().updUserpwd(user, userId);
	}

	@Override
	public User getUserByInfo(int userId) {
		// TODO Auto-generated method stub
		return new UserDao().getUserByInfo(userId);
	}

	@Override
	public PageBean getUserPageBean(PageBean pagebean, String userName) {
		// TODO Auto-generated method stub
		return new UserDao().getUserPageBean(pagebean, userName);
	}
}
