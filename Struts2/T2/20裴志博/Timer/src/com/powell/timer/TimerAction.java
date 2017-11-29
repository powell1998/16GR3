package com.powell.timer;

import com.opensymphony.xwork2.Action;

public class TimerAction implements Action {
	private String content;
	private String uname;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "你好" + uname;
		return Action.SUCCESS;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

}
