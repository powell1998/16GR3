package com.powell.t5.dao;

import java.util.List;

import com.powell.t5.bean.User;

public interface UserDao {
	
	/**
	 * @param user
	 * @return
	 * 添加用户业务Dao接口
	 * @throws Exception 
	 */
	public int addUser(User user) throws Exception;
	
	/**
	 * @param id
	 * @return
	 * 删除用户业务Dao接口
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws Exception;
	
	/**
	 * @param id
	 * @return
	 * 更新用户业务Dao接口
	 * @throws Exception 
	 */
	public int upDateUser(User user) throws Exception;
	
	/**
	 * @return
	 * 查询用户业务Dao接口
	 * @throws Exception 
	 */
	public List<User> getAllUser() throws Exception;
	
	/**
	 * @param user
	 * @return
	 * 通过Id查询
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;

}
