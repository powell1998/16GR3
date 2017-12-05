package com.powell.t6.action;

import com.opensymphony.xwork2.ActionSupport;
import com.powell.t6.bean.User;

public class UserAction extends ActionSupport {
	private User user;
	
	@Override
	public void validate() {
		if("".equals(user.getUname())) {
			//为空，报告错误
			super.addFieldError("user.uname", "用户名不能为空");
		}
		if("".equals(user.getUpwd())) {
			//为空，报告错误
			super.addFieldError("user.upwd", "密码不能为空");
		}
	}

	public String login() {
		
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
