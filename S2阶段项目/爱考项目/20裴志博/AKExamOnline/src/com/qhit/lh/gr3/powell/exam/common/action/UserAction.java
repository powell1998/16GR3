package com.qhit.lh.gr3.powell.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.powell.exam.common.bean.User;
import com.qhit.lh.gr3.powell.exam.common.service.UserService;
import com.qhit.lh.gr3.powell.exam.common.service.UserServiceImpl;

public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 * 登陆的业务处理方法
	 * @return
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//登陆成功，储存user对象到session中
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！请重新登录");
			return "loginFail";
		}
	}
	
	/**
	 * @return
	 * 退出
	 */
	public String logout(){
		//获取session对象，并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
