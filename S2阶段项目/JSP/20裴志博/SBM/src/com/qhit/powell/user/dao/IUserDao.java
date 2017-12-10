package com.qhit.powell.user.dao;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.user.bean.User;

public interface IUserDao {

	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录
	 */
	User doLogin(String userName, String userPassword);
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	int addUser(User user);
	
	/**
	 * @param pageBean
	 * @return
	 * 分页数据的访问
	 */
	PageBean getPageBean(PageBean pagebean);
	
	/**
	 * @param user
	 * @return
	 * 删除
	 */
	int delUser(int userId);
	
	/**
	 * @return
	 * 修改
	 */
	int updUser(int userId);
	
	/**
	 * @param userId
	 * @return
	 * 通过ID获取用户信息
	 */
	User getUserById(String userId);
	
	/**
	 * @param userId
	 * @return
	 * 修改密码
	 */
	int updUserpwd(User user,int userId);
	
	/**
	 * @param userId
	 * @return
	 * 通过ID查询所有用户信息
	 */
	User getUserByInfo(int userId);
	
	/**
	 * @param pagebean
	 * @param userName
	 * 获取用户数据分页
	 * @return
	 */
	PageBean getUserPageBean(PageBean pagebean,String userName);
}