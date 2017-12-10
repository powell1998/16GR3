package com.qhit.powell.user.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.common.service.CommonService;
import com.qhit.powell.common.service.ICommonService;
import com.qhit.powell.user.bean.User;
import com.qhit.powell.user.service.IUserService;
import com.qhit.powell.user.service.UserService;
import com.qhit.powell.utils.CommonUtil;
import com.qhit.powell.utils.IDUtil;

public class UserServlet extends HttpServlet {
	
	private ICommonService commonService = new CommonService();
	private IUserService userService = new UserService();
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "doLogin": //登录
			doLogin(request,response);
			break;
		case "Exit": //退出
			Exit(request,response);
			break;
		case "uploadPic": //更新用户信息
			uploadPic(request,response);
			break;
		case "addUser": //添加用户
			addUser(request,response);
			break;
		case "selectUsers"://查询用户
			selectUsers(request,response);
			break;
		case "retrievalUser":
			retrievalUser(request,response);
			break;
		case "delUser": //删除用户
			delUser(request,response);
			break;
		case "getUser": //获取用户
			getUser(request,response);
			break;
		
		default:
			break;
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageBean pagebean = new PageBean();
		String p = request.getParameter("userName");
		String userName = request.getParameter("userName");
		List<String> wheres = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(userName != null && userName != ""){
			wheres.add("userName");
			values.add(userName);
		}
		int count = commonService.getCount("tb_user", wheres, values);
		pagebean.setCount(count);
		int up = 1;
		if(p != null && p != ""){
			up = Integer.parseInt(p);
		}
		pagebean.setCount(up);
		pagebean = userService.getUserPageBean(pagebean, userName);
		request.setAttribute("pagebean", pagebean);
		if(pagebean.getData().size() > 0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/userAdmin.jsp");
			requestDispatcher.forward(request, response);
		}else{
			response.sendRedirect("userAdmin.jsp?sele=No");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		int count = userService.delUser(userId);
		if(count > 0){
			response.sendRedirect("user?cmd=selectUsers");
		}else{
			response.sendRedirect("user?cmd=selectUsers&del=No");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void retrievalUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		User user = userService.getUserById(userId);
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/userupd.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * 查询用户信息
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void selectUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PageBean pagebean=new PageBean();
		String ins = request.getParameter("ins");
		String ups = request.getParameter("ups");
		List<String> wheres=new ArrayList<String>();
		List<String> values=new ArrayList<String>();
		int count = commonService.getCount("tb_user", wheres, values);
		pagebean.setCount(count);
		int up = 1;
		String p = request.getParameter("p");
		System.out.println("up1:"+up);
		if(p != null && p != ""){
			up = Integer.parseInt(p);
			System.out.println("up2:"+up);
		}
		System.out.println("up3:"+up);
		pagebean.setP(up);
		System.out.println("setp:"+up);
		pagebean = userService.getPageBean(pagebean);
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("ins", ins);
		request.setAttribute("ups", ups);
		if(pagebean.getData().size() == 0){
			response.sendRedirect("jsp/userAdmin.jsp?sele=No");
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/userAdmin.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * 添加用户
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String userName = (String) request.getAttribute("userName");
		String userPassword = (String) request.getAttribute("userPassword");
		String userSex = (String) request.getAttribute("userSex");
		String userAge = (String) request.getAttribute("userAge");
		String telephone = (String) request.getAttribute("telephone");
		String address = (String) request.getAttribute("address");
		String pic = (String) request.getAttribute("pic");
		String type = (String) request.getAttribute("type");
		
		User user = new User(
				userName, 
				userPassword, 
				userSex, 
				Integer.parseInt(userAge), 
				telephone, 
				address, 
				pic, 
				Integer.parseInt(type));
		
		int row = userService.addUser(user);
		
		PrintWriter out = response.getWriter();
		
		if(row > 0){
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			out.print("<script>alert('添加失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 上传头像
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void uploadPic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//实例化对象
		SmartUpload smartUpload = new SmartUpload();
		//初始化上传文件的对象
		smartUpload.initialize(getServletConfig(), request, response);
		//设置只允许上传的图片格式
		smartUpload.setAllowedFilesList("png,jpg,JPEG,gif");
		//设置上传的图片的大小
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			//上传
			smartUpload.upload();
			//保存
			//图片保存的文件夹路径
			String realPath = request.getRealPath("/")+"/";//项目路径
			String filePath = CommonUtil.FILE_USER_PIC_PHOTO_PATH;
			File file = new File(realPath+filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//图片保存的名称
			String picName = IDUtil.getUUID();
			//图片的后缀名
			com.jspsmart.upload.File picFile = smartUpload.getFiles().getFile(0);
			String picFileExt = picFile.getFileExt();
			//最终获取到的文件相对路径
			String picPath = filePath+picName+"."+picFileExt;
			//保存文件
			picFile.saveAs(realPath+picPath);
			//头像上传成功，之后根据表单提交的数据和获取头像图片的存储路径插入数据表中：因为需要之前表单的所有的数据所以需要用到请求转发
			//添加用户头像的路径到request对象中，转发出去
			Request sRequest = smartUpload.getRequest();
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			requestDispatcher.forward(request, response);
		} catch (SmartUploadException e) {
			//异常处理
			out.print("<script>alert('上传头像失败，请检查图片格式和大小');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 退出
	 * @throws IOException 
	 */
	private void Exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
//		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doLogin(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		IUserService userService = new UserService();
		User user = userService.doLogin(userName, userPassword);
		
		if(user != null){
			/**
			 * 登录 成功
			 */
			//保存到用户信息会话中
			request.getSession().setAttribute("user",user);
			//获取在线用户的集合
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for(User use:users){
				if(user.getUserId()==use.getUserId()){
					response.sendRedirect("jsp/admin_index.jsp");
					return;
				}
			}
			//添加当前用户到在线用户集合
			users.add(user);
			//更新用户在线集合
			request.getServletContext().setAttribute("online", users);
			//跳转页面
			response.sendRedirect("jsp/admin_index.jsp");
		}else{
			//登录失败
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}
}
