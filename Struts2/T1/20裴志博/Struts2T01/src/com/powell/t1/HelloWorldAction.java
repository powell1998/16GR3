package com.powell.t1;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;//保存回应结果数据
	private String uname;
	@Override
	//相应用户请求，业务处理方法
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "你好!" + uname;
		return Action.SUCCESS;
	}

	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
