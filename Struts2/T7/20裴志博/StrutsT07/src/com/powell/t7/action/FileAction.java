package com.powell.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private String uname;
	private File uploadFile;
	
	private String uploadFileFileName;//文件名
	private String uploadFileContentType;//文件类型
	
	/**
	 * @return
	 * 处理上传文件的业务
	 */
	public String upload() {
		if(uploadFile != null) {
			/*
			 *上传的业务
			 * 1.读取上传的文件
			 * 		输入流--》先获取上传文件的输入流
			 * 2.保存到服务器
			 * 		写之前，创建用来保存的文件（localhost：8080/StrutsT07/upload/uploadFileFileName）
			 * 		输出流--》根据创建的文件，写入数据
			 */
			try {
				//1.读取上传的文件
				InputStream is = new FileInputStream(uploadFile);
				//写之前，创建用来保存的文件（localhost：8080/StrutsT07/upload/uploadFileFileName）
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//如果文件夹不存在，就创建一个
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				//输出流
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//根据创建的文件写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败！");
			}
		}else {
			super.addFieldError("uploadFile", "文件未找到！");
		}
		return "uploadSuccess";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

}
