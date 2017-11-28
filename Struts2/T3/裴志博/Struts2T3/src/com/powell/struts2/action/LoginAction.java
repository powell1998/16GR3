package com.powell.struts2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.powell.struts2.bean.UserInfo;

public class LoginAction implements Action {
	private UserInfo userinfo;//封装请求参数
	private String name;//用户名
	private String password;//密码

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(name==null || name.equals("") || password==null || password.equals("")){
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名和密码不能为空！");
			return Action.INPUT;
		}
		if(name.equals("tom") && password.equals("123456")){
			ServletActionContext.getRequest().getSession().setAttribute("loginuser", name);
			return Action.SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "用户名或密码不对！");
			return Action.INPUT;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserInfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}
