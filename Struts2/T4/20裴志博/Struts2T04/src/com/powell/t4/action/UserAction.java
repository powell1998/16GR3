package com.powell.t4.action;

import com.opensymphony.xwork2.Action;
import com.powell.t4.bean.UserInfo;

public class UserAction implements Action {
	private UserInfo userinfo;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}
