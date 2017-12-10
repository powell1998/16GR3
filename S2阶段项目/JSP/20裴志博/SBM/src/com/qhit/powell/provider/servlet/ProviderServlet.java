package com.qhit.powell.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.common.service.CommonService;
import com.qhit.powell.common.service.ICommonService;
import com.qhit.powell.goods.bean.Goods;
import com.qhit.powell.goods.service.GoodsService;
import com.qhit.powell.provider.bean.Provider;
import com.qhit.powell.provider.service.IProviderService;
import com.qhit.powell.provider.service.ProviderService;
import com.qhit.powell.user.bean.User;

public class ProviderServlet extends HttpServlet {
	private IProviderService providerService = new ProviderService();
	private ICommonService commonService = new CommonService();
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getAllProvider": //查询
			getAllProvider(request, response);
			break;
		case "getSm": //分页查询数据
			getSm(request, response);
			break;	
		case "delProvider": //删除
			delProvider(request, response);
			break;	
		case "addProvider": //添加
			addProvider(request, response);
			break;	
		case "getproviderById": //根据ID查询信息做修改操作
			getproviderById(request, response);
			break;	
		case "updprovider": //修改
			updprovider(request, response);
			break;	
		
		default:
			break;
		}
	}

	private void updprovider(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收修改表值
		String act=request.getParameter("act");
		String providerName = request.getParameter("providerName");
		String providerDetail = request.getParameter("providerDetail");
		String contact = request.getParameter("contact");
		String telephone = request.getParameter("telephone");
		String facsimile = request.getParameter("facsimile");
		String address = request.getParameter("address");
		
		if(act.equals("addProvider")) {
			Provider provider=new Provider(providerName, providerDetail, contact, telephone, facsimile, address);
			request.setAttribute("provider", provider);
			RequestDispatcher rd=request.getRequestDispatcher("provider?cmd=addProvider");
			rd.forward(request, response);
			return;
		}else {
		//组装对象，调用方法修改
		int	providerId = Integer.parseInt(request.getParameter("providerId"));
		Provider provider=new Provider(providerId, providerName, providerDetail, contact, telephone, facsimile, address);
		int count = providerService.updProvider(provider);
		if(count == 1) {
			response.sendRedirect("provider?cmd=getSm");
		}else {
			response.sendRedirect("provider?cmd=getSm");
			}
		}
	}

	private void getproviderById(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int providerId = Integer.parseInt(request.getParameter("providerId"));
		Provider provider = providerService.getProviderById(providerId);
		request.setAttribute("provider", provider);
		if(provider != null) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/updprovider.jsp");
			rd.forward(request, response);
		}else {
			PrintWriter out=response.getWriter();
			out.print("<script>alert('系统错误，请重新尝试！');</script>");
		}
	}

	private void addProvider(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerName = request.getParameter("providerName");
		String providerDetail = request.getParameter("providerDetail");
		String contact = request.getParameter("contact");
		String telephone = request.getParameter("telephone");
		String facsimile = request.getParameter("facsimile");
		String address = request.getParameter("address");
		Provider provider = new Provider(
				providerName, 
				providerDetail, contact, telephone, facsimile, address);
		int count = providerService.addProvider(provider);
		if(count == 1) {
			response.sendRedirect("provider?cmd=getSm");
		}else {
			response.sendRedirect("provider?cmd=getSm");
		}
	}

	private void delProvider(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int providerId = Integer.parseInt(request.getParameter("providerId"));
		int count = providerService.delProvider(providerId);
		if(count > 0){
			response.sendRedirect("provider?cmd=getSm");
		}else{
			response.sendRedirect("provider?cmd=getSm");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getSm(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		/**
		 * pagesize=5
		 * data:实例化
		 * count：1
		 * pagetotal:2
		 * p:3
		 * */
		PageBean pageBean = new PageBean();
		int count = commonService.getCount("tb_provider", null, null);
		pageBean.setCount(count);
		
		String p = request.getParameter("p");
		if(p != null && p != ""){
			//有参数p
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数，第一次进入
			pageBean.setP(1);
		}
		
		pageBean = providerService.getPageBean(pageBean);
		//保存数据
		request.getSession().setAttribute("pageBean", pageBean);
		//重定向
//		response.sendRedirect("jsp/admin_index.jsp");
		if(p != null && p != ""){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/providerAdmin.jsp'</script>");
		}else{
			response.sendRedirect("jsp/providerAdmin.jsp");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAllProvider(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Provider> list = providerService.getAllProvider();
		
		request.setAttribute("providers", list);
		if(action.equals("add")){
			//查完之后:如果是添加账单，转发到添加账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//查完之后：如果是修改账单，那就转发到修改账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
	}
}
