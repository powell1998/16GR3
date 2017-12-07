package com.powell.t5.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.powell.t5.bean.User;
import com.powell.t5.service.UserService;
import com.powell.t5.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private User user;
	private List<User> users;
	private UserService uService = new UserServiceImpl();
	
	/**
	 * @return
	 * 添加用户
	 */
	public String add() {
		try {
			uService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "addSuccess";
		
	}
	/**
	 * @return
	 * 删除用户
	 */
	public String delete() {
		try {
			uService.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "deleteSuccess";
		
	}
	/**
	 * @return
	 * 准备更新
	 */
	public String toupdate() {
		try {
			uService.getUserById(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
		
	}
	/**
	 * @return
	 * 更新用户
	 */
	public String update() {
		try {
			uService.upDateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "updateSuccess";
		
	}
	/**
	 * @return
	 * 查询用户
	 */
	public String getAllUser() {
		try {
			users = uService.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "success";
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
