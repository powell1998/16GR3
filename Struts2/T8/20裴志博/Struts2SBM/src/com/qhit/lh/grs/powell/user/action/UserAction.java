/**
 * 
 */
package com.qhit.lh.grs.powell.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.powell.user.bean.User;
import com.qhit.lh.grs.powell.user.service.UserService;
import com.qhit.lh.grs.powell.user.service.impl.UserServiceImpl;

/**
 * @author 裴志博
 * TODO
 * 2017年12月7日下午5:41:04
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	private User user;
	private List<User> users = new ArrayList<>();
	
	private File userPhoto;
	private String userPhotoFileName;
	private String userPhotoContentType;
	
	/**
	 * @return
	 * 登录
	 */
	public String login(){
		boolean isLogin = false;
		user = userService.doLogin(user.getUserName(), user.getUserPassword());
		if(user != null){
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}else{
			//登录失败
			super.addFieldError("loginFail", "账户名密码有误！");
		}
		return "loginSuccess";
	}
	
	/**
	 * @return
	 * 上传
	 */
	public String uploadPhoto(){
		try {
			InputStream is = new FileInputStream(userPhoto);
			String path = ServletActionContext.getServletContext().getRealPath("/")+"upload";
			//头像的相对路径
			String pic = "upload/"+userPhotoFileName;
			//设置到user对象中，方便添加用户的时候插入数据
			user.setPic(pic);
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			OutputStream os = new FileOutputStream(path+"/"+userPhotoFileName);
			byte[] b = new byte[8096];
			int len = 0;
			try {
				while((len=is.read(b))!=-1){
					os.write(b, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				os.flush();
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "uploadPfotoSuccess";
	}
	
	/**
	 * @return
	 * 添加
	 */
	public String add(){
		int row = userService.addUser(user);
		if(row > 0){
			//添加成功
			return "addSuccess";
		}else{
			super.addFieldError("addFail", "用户添加失败!");
			return "addFile";
		}
	}
	
	/**
	 * @return
	 * @throws Exception 
	 * 查询所有
	 */
	public String getAll() throws Exception{
		users = userService.getAll();
		return "listUser";
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
	public File getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserPhotoFileName() {
		return userPhotoFileName;
	}
	public void setUserPhotoFileName(String userPhotoFileName) {
		this.userPhotoFileName = userPhotoFileName;
	}
	public String getUserPhotoContentType() {
		return userPhotoContentType;
	}
	public void setUserPhotoContentType(String userPhotoContentType) {
		this.userPhotoContentType = userPhotoContentType;
	}
}
