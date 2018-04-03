package com.qhit.lh.gr3.powell.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.bcel.classfile.Constant;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.gr3.powell.exam.common.bean.User;
import com.qhit.lh.gr3.powell.exam.common.utils.Constans;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("登录效验拦截器执行");
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//未登录
			return Constans.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
